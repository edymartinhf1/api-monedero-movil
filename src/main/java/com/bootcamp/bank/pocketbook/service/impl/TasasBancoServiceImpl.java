package com.bootcamp.bank.pocketbook.service.impl;

import com.bootcamp.bank.pocketbook.model.dao.TasaBancoDao;
import com.bootcamp.bank.pocketbook.model.dao.repository.TasasBancoRepository;
import com.bootcamp.bank.pocketbook.service.TasasBancoService;
import com.bootcamp.bank.pocketbook.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Log4j2
@RequiredArgsConstructor
public class TasasBancoServiceImpl implements TasasBancoService {

    private final TasasBancoRepository tasasBancoRepository;

    @Override
    public Mono<TasaBancoDao> saveTasa(TasaBancoDao tasaBancoDao) {
        tasaBancoDao.setFechaCreacion(Util.getCurrentDate());
        tasaBancoDao.setFechaCreacionT(Util.getCurrentDateAsString("yyyy-MM-dd"));
        return tasasBancoRepository.save(tasaBancoDao);
    }

    @Override
    public Flux<TasaBancoDao> findAll() {
        return tasasBancoRepository.findAll();
    }

    @Override
    public Mono<TasaBancoDao> updateTasa(TasaBancoDao tasaBancoDao) {
        return tasasBancoRepository.findById(tasaBancoDao.getId()).flatMap(tasaBanco ->{
           return tasasBancoRepository.save(tasaBanco);
        });
    }
}
