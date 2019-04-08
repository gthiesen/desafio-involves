package com.involves.desafio.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.involves.desafio.entity.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Serializable> {

	List<Loja> findAllByRepresentanteIsNull();

	List<Loja> findAllByNomeLike(String nome);

	@Query("update Loja set dataRemocao = CURRENT_TIMESTAMP")
	@Modifying
	void deleteLogic(Long id);

}
