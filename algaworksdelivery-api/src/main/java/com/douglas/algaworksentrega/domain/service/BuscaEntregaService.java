package com.douglas.algaworksentrega.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.algaworksentrega.domain.exception.EntidadeNaoEncontradaException;
import com.douglas.algaworksentrega.domain.model.Entrega;
import com.douglas.algaworksentrega.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {
	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return  entregaRepository.findById(entregaId)
			.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	
	}
}
