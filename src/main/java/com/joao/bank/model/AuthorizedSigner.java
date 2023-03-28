package com.joao.bank.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "authorized_signer")
public class AuthorizedSigner{

	@Id
	private String id;
    private String name;
    private String dni;
    private String idClient;
    private String idAccount;
}
