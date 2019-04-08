package com.involves.desafio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.involves.desafio.dao.LojaRepository;
import com.involves.desafio.entity.Loja;
import com.involves.desafio.entity.Representante;
import com.involves.desafio.entity.RepresentanteLoja;
import com.involves.desafio.util.DistanciaUtil;

@Component
@Transactional
public class LojaService {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private RepresentanteService representanteService;
	
	@Autowired
	private RepresentanteLojaService representanteLojaService;
	
	private static final Logger _logger = LogManager.getLogger(LojaService.class);
	
	public Loja save(Loja entity)	{
		return lojaRepository.saveAndFlush(entity);
	}


	public boolean hasLojas() {
		return lojaRepository.count() > 0;
	}
	
	public void atribuirRepresentantes()	{
		List<Loja> lojas = lojaRepository.findAll();
		List<Representante> representantes = representanteService.findAll();
		
		_logger.info(" ");
		_logger.info("==========================================================");
		_logger.info("Atribuindo representantes potenciais");
		_logger.info("==========================================================");
		_logger.info(" ");

		for (Loja loja : lojas) { //itera as lojas existentes
			
			_logger.info("==========================================================");
			_logger.info("Avaliando Loja ..." +loja.getNome());
			
			for (Representante representante : representantes) { //itera os representantes potenciais
				double distancia = DistanciaUtil.haversine(loja.getLatitude(), loja.getLongitude(), representante.getLatitude(), representante.getLongitude());
				if (distancia < 2)	{ //Se esse representante está na distância certa, atribui ele aos potenciais
					RepresentanteLoja representanteLoja = new RepresentanteLoja();
					representanteLoja.setRepresentante(representante);
					representanteLoja.setLoja(loja);
					representanteLoja.setDistancia(distancia);
					
					representanteLojaService.save(representanteLoja);
					_logger.info("Representante próximo ..." +representante.getNome()+" ( "+distancia+") ");
				}
			}
			
		}
		
		_logger.info("==========================================================");
		
		atribuirRepresentanteUnicaOpcao();
		atribuirRepresentanteMultiplaOpcao();

	}
	
	
	/**
	 * Atribui os representantes para as Lojas conforme regras:
	 * 
	 * 1- Se for o único da região, atribui como representante da loja
	 * 2- Se dentre os próximos, for o que tem menos lojas
	 * 3- Se tem o mesmo numero de lojas, atribui o mais próximo
	 * 
	 */
	private void atribuirRepresentanteUnicaOpcao()	{
		
		List<Loja> lojas = lojaRepository.findAll();
		
		_logger.info(" ");
		_logger.info("==========================================================");
		_logger.info("Atribuindo únicas opções de representantes para lojas");
		_logger.info("==========================================================");
		_logger.info(" ");
		
		for (Loja loja : lojas) { //itera as lojas existentes
			
			_logger.info("==========================================================");
			_logger.info("Avaliando Loja ..." +loja.getNome());

			if (loja.getRepresentantesProximos().size() == 0)	{
				_logger.info("Loja: "+loja.getNome()+" | Nenhum representante na região.");
				continue; //Sem representantes, segue para próxima loja
			}	
			
			if (loja.getRepresentantesProximos().size() == 1)	{
				Representante representante = loja.getRepresentantesProximos().get(0).getRepresentante();
				loja.setRepresentante(representante);
				_logger.info("Loja: "+loja.getNome()+" | Atribuído para "+ representante.getNome() + " por ser o único da região");
				continue; //Representante encontrado, segue o laço
			}

			lojaRepository.save(loja);
		}
		
	}
	
	private void atribuirRepresentanteMultiplaOpcao()	{
		
		_logger.info(" ");
		_logger.info("==========================================================");
		_logger.info("Atribuindo múltiplas opções de representantes para lojas");
		_logger.info("==========================================================");
		_logger.info(" ");
		
		List<Loja> lojas = lojaRepository.findAll();

		for (Loja loja : lojas) { //itera as lojas existentes
			
			if (loja.getRepresentantesProximos().size() < 2) continue;

			_logger.info("==========================================================");
			_logger.info("Avaliando Loja ..." +loja.getNome());
			
			RepresentanteLoja selecionado = null;
			for (RepresentanteLoja representanteLoja : loja.getRepresentantesProximos()) {
				if (selecionado == null)	{
					selecionado = representanteLoja;
					_logger.info("Atribuído para "+ selecionado.getRepresentante().getNome());
					continue;
				}
				if (representanteLoja.getRepresentante().getLojas().size() < selecionado.getRepresentante().getLojas().size())	{
					selecionado = representanteLoja;
					_logger.info("Atribuído para "+ selecionado.getRepresentante().getNome() + " por ser o com menor numero de lojas.");
					continue;
				}
				if (representanteLoja.getRepresentante().getLojas().size() == selecionado.getRepresentante().getLojas().size())	{
					if (representanteLoja.getDistancia() < selecionado.getDistancia())	{
						selecionado = representanteLoja;
						_logger.info("Atribuído para "+ selecionado.getRepresentante().getNome() + " por ser o com menor distância.");
					}
					continue;
				}
			}
			
			loja.setRepresentante(selecionado.getRepresentante());

			lojaRepository.save(loja);
		}
		
	}


	public void deleteLogic(Long id) {
		lojaRepository.deleteLogic(id);
		
	}


	public Optional<Loja> findById(Long id) {
		return lojaRepository.findById(id);
	}


	public List<Loja> findAll() {
		
		return lojaRepository.findAll();
	}


}
