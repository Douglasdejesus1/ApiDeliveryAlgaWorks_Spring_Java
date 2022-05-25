package com.douglas.algaworksentrega.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.algaworksentrega.api.assembler.OcorrenciaAssembler;
import com.douglas.algaworksentrega.api.model.OcorrenciaModel;
import com.douglas.algaworksentrega.api.model.input.OcorrenciaInput;
import com.douglas.algaworksentrega.domain.model.Entrega;
import com.douglas.algaworksentrega.domain.model.Ocorrencia;
import com.douglas.algaworksentrega.domain.service.BuscaEntregaService;
import com.douglas.algaworksentrega.domain.service.RegistroOcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;
	@Autowired
	private OcorrenciaAssembler ocorrenciaAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
		
	}
	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
		
	}
	
}