package com.joao.bank.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.joao.bank.enums.ClientType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
public class Client {
	
    @Id
    private String id;
    private String name;
    private ClientType clientType;
    
    
}