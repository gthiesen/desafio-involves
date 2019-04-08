package com.involves.desafio.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.involves.desafio.entity.RepresentanteLoja;

@Repository
public interface RepresentanteLojaRepository extends JpaRepository<RepresentanteLoja, Serializable> {

}
