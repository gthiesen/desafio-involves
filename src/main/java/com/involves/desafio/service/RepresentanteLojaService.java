package com.involves.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.involves.desafio.dao.RepresentanteLojaRepository;
import com.involves.desafio.entity.RepresentanteLoja;

@Component
public class RepresentanteLojaService {

	@Autowired
	private RepresentanteLojaRepository representanteLojaRepository;
	
	public RepresentanteLoja save(RepresentanteLoja entity)	{
		return representanteLojaRepository.saveAndFlush(entity);
	}

}
