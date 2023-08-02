package com.bootcamp.bank.pocketbook.model.dao.repository;

import com.bootcamp.bank.pocketbook.model.dao.TasaBancoDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TasasBancoRepository  extends ReactiveMongoRepository<TasaBancoDao,String> {
    Mono<TasaBancoDao> findByFechaTasaT(String fechaTasa);
}
