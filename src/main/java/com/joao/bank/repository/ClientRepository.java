package com.joao.bank.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joao.bank.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findById(String id);
}
