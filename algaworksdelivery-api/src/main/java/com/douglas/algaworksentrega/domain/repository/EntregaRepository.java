package com.douglas.algaworksentrega.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.douglas.algaworksentrega.domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Long> {

	
}