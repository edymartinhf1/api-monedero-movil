package com.bootcamp.bank.pocketbook.model.dao.repository;

import com.bootcamp.bank.pocketbook.model.dao.TasaBancoDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasasBancoRepository  extends ReactiveMongoRepository<TasaBancoDao,String> {

}
