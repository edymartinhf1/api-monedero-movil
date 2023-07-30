package com.bootcamp.bank.pocketbook.model.dao.repository;

import com.bootcamp.bank.pocketbook.model.dao.MonederoMovilDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonederoMovilRepository extends ReactiveMongoRepository<MonederoMovilDao,String> {
}
