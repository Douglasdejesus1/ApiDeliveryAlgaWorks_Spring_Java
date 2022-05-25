package com.douglas.algaworksentrega.domain.service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.algaworksentrega.domain.model.Cliente;
import com.douglas.algaworksentrega.domain.model.Entrega;
import com.douglas.algaworksentrega.domain.model.StatusEntrega;
import com.douglas.algaworksentrega.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	@Autowired
	private CatalogoClienteService catalogoClienteService;
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
