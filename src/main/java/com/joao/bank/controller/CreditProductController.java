package com.joao.bank.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joao.bank.enums.ClientType;
import com.joao.bank.model.Client;
import com.joao.bank.model.CreditProduct;
import com.joao.bank.service.ClientService;
import com.joao.bank.service.Exception.InvalidRequestException;
import com.joao.bank.service.Exception.ResourceNotFoundException;

@RestController
@RequestMapping("/credit-product")
public class CreditProductController {

	@Autowired
    private ClientService clientService;

	 @PostMapping("/{idClient}/save")
	    public ResponseEntity<CreditProduct> createCreditProduct(@PathVariable String idClient, @RequestBody @Valid CreditProduct creditProduct) {
	        Client client = clientService.getClientById(idClient);
	        if (client == null) {
	            throw new ResourceNotFoundException("Cliente no encontrado con el ID proporcionado: " + idClient);
	        }
	        if (!client.getClientType().equals(ClientType.PERSONAL)) {
	            throw new InvalidRequestException("Solo se pueden crear créditos para clientes personales");
	        }
	        creditProduct.setIdClient(idClient);
	        creditProduct = clientService.createCreditProduct(creditProduct);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(creditProduct.getId())
	                .toUri();
	        return ResponseEntity.created(location).body(creditProduct);
	    }
}
