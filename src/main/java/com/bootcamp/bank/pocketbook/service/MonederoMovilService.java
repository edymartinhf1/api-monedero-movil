package com.bootcamp.bank.pocketbook.service;

import com.bootcamp.bank.pocketbook.model.dao.MonederoMovilDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MonederoMovilService {
    Mono<MonederoMovilDao> save(MonederoMovilDao monederoMovilDao);

    void saveFromkafka(MonederoMovilDao monederoMovilDao);

    Flux<MonederoMovilDao> findAll(Integer limit);
}
