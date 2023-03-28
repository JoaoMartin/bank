package com.joao.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joao.bank.model.CreditCard;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

}

