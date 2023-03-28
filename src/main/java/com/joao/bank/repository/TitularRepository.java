package com.joao.bank.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joao.bank.model.Titular;

public interface TitularRepository extends MongoRepository<Titular, String> {
    List<Titular> findByIdClient(String idClient);
    List<Titular> findByIdAccount(String idAccount);

}
