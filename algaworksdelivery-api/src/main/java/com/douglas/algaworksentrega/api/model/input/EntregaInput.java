package com.douglas.algaworksentrega.api.model.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EntregaInput {

	@Valid
	//@NotNull
	private ClienteIdInput cliente;
	@Valid
	@NotNull
	private DestinatarioInput destinatario;
	@NotNull
	private BigDecimal taxa;
	
}
