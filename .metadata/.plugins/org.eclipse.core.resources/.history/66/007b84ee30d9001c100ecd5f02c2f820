package com.douglas.algaworksentrega.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.algaworksentrega.domain.exception.NegocioException;
import com.douglas.algaworksentrega.domain.model.Cliente;
import com.douglas.algaworksentrega.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
			.stream()
			.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso){
			throw new NegocioException("Já existe um cliente cadastrado com esse email");
		}
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}
