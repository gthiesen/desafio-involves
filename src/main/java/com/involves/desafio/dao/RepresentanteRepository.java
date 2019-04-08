package com.involves.desafio.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.involves.desafio.entity.Representante;

@Repository
public interface RepresentanteRepository extends JpaRepository<Representante, Serializable> {

	@Query("update Representante set dataRemocao = CURRENT_TIMESTAMP")
	@Modifying
	void deleteLogic(Long id);

}
