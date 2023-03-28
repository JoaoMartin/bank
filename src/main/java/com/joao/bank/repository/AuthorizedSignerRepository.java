package com.joao.bank.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joao.bank.model.AuthorizedSigner;

public interface AuthorizedSignerRepository extends MongoRepository<AuthorizedSigner, String> {
    List<AuthorizedSigner> findByIdClient(Long idClient);
}