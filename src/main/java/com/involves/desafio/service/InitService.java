package com.involves.desafio.service;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.involves.desafio.entity.Loja;
import com.involves.desafio.entity.Representante;

@Component
public class InitService implements ApplicationListener<ContextRefreshedEvent> {
	
	public static String VERSAO = "0.0.0 - beta";
	
	private static final Logger _logger = LogManager.getLogger(InitService.class);
	
	@Autowired
	private LojaService lojaService;
	
	@Autowired
	private RepresentanteService representanteService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		_logger.info("==========================================================");
		_logger.info("Inicializando aplicação ...");
		_logger.info("==========================================================");
		
		initRepresentantes();
		initLojas();
		//atribuirRepresentantes();
	}

	private void atribuirRepresentantes() {
		_logger.info("==========================================================");
		_logger.info("Atribuindo Representantes ...");
		_logger.info("==========================================================");
		
		lojaService.atribuirRepresentantes();
	}

	private void initLojas() {
		
		_logger.info("==========================================================");
		_logger.info("Inicializando lojas ...");
		_logger.info("==========================================================");
		
		if (lojaService.hasLojas()) return;

		Scanner s = new Scanner(getClass().getResourceAsStream("/lojas.csv"));
		s.nextLine(); //cabeçalho
		
		while(s.hasNextLine()){
			
			String linha = s.nextLine();
			_logger.info("Carregando loja: "+linha);
			
			String[] funcionario = linha.split(",");
			String nome = funcionario[0];
			Double latitude = Double.valueOf(funcionario[1]);
			Double longitude = Double.valueOf(funcionario[2]);
			
			Loja loja = new Loja();
			loja.setNome(nome);
			loja.setLatitude(latitude);
			loja.setLongitude(longitude);
			lojaService.save(loja);
			
		}

		
	}

	private void initRepresentantes() {
		
		_logger.info("==========================================================");
		_logger.info("Inicializando representantes ...");
		_logger.info("==========================================================");
		
		if (representanteService.hasRepresentantes()) return;

		Scanner s = new Scanner(getClass().getResourceAsStream("/funcionarios.csv"));
		s.nextLine(); //cabeçalho
		
		while(s.hasNextLine()){
			
			String linha = s.nextLine();
			_logger.info("Carregando representante: "+linha);
			
			String[] funcionario = linha.split(",");
			
			String nome = funcionario[0];
			Double latitude = Double.valueOf(funcionario[1]);
			Double longitude = Double.valueOf(funcionario[2]);
			
			Representante representante = new Representante();
			representante.setNome(nome);
			representante.setLatitude(latitude);
			representante.setLongitude(longitude);
			
			representanteService.save(representante);
			
		}
		
	}

}