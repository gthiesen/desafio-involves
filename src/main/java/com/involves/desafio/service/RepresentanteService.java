package com.involves.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.involves.desafio.dao.RepresentanteRepository;
import com.involves.desafio.entity.Representante;

@Component
public class RepresentanteService {

	@Autowired
	private RepresentanteRepository representanteRepository;
	
	public Representante save(Representante entity)	{
		return representanteRepository.saveAndFlush(entity);
	}


	public boolean hasRepresentantes() {
		return representanteRepository.count() > 0;
	}


	public List<Representante> findAll() {
		return representanteRepository.findAll();
	}


	public Optional<Representante> findById(Long id) {
		return representanteRepository.findById(id);
	}


	public void deleteLogic(Long id) {
		representanteRepository.deleteLogic(id);
	}

	
}
