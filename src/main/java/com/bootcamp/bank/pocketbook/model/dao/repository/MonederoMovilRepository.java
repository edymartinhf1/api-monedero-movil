package com.bootcamp.bank.pocketbook.model.dao.repository;

import com.bootcamp.bank.pocketbook.model.dao.MonederoMovilDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MonederoMovilRepository extends ReactiveMongoRepository<MonederoMovilDao,String> {
    Mono<MonederoMovilDao> findByIdClienteAndNumeroCelular(String idCliente, String numeroCelular);
}
