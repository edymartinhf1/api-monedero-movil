package com.bootcamp.bank.pocketbook.service;

import com.bootcamp.bank.pocketbook.model.dao.TasaBancoDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TasasBancoService {
    Mono<TasaBancoDao> saveTasa(TasaBancoDao tasaBancoDao);

    Flux<TasaBancoDao> findAll();

    Mono<TasaBancoDao> updateTasa(TasaBancoDao tasaBancoDao);
}
