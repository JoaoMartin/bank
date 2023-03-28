package com.joao.bank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joao.bank.model.Movements;


@Repository
public interface MovementsRepository  extends MongoRepository<Movements, String> {

}

