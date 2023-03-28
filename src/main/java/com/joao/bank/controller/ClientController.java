package com.joao.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.joao.bank.model.Client;
import com.joao.bank.service.ClientService;
import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

	 @Autowired
	 private ClientService clientService;
	 
	 @PostMapping
	 public ResponseEntity<?> crearCliente(@RequestBody @Valid Client client) {
	     client = clientService.createClient(client);
	     return ResponseEntity.created(URI.create("/clientes/" + client.getId())).build();
	 }
}
