package com.bootcamp.bank.pocketbook.model.dao.repository;

import com.bootcamp.bank.pocketbook.model.dao.MonederoOperacionDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonederoOperacionRepository extends ReactiveMongoRepository<MonederoOperacionDao,String> {

}
