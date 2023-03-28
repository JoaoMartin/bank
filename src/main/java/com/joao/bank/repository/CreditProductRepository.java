package com.joao.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joao.bank.model.CreditProduct;

@Repository
public interface CreditProductRepository extends MongoRepository<CreditProduct, String> {
    Optional<CreditProduct> findById(String id);
    List<CreditProduct> findByIdClient(String idClient);
}
