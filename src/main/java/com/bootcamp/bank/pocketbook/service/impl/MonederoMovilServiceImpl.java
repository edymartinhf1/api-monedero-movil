package com.bootcamp.bank.pocketbook.service.impl;

import com.bootcamp.bank.pocketbook.model.dao.MonederoMovilDao;
import com.bootcamp.bank.pocketbook.model.dao.repository.MonederoMovilRepository;
import com.bootcamp.bank.pocketbook.service.MonederoMovilService;
import com.bootcamp.bank.pocketbook.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Log4j2
@RequiredArgsConstructor
public class MonederoMovilServiceImpl implements MonederoMovilService {

    private final MonederoMovilRepository monederoMovilRepository;

    @Override
    public Mono<MonederoMovilDao> save(MonederoMovilDao monederoMovilDao) {
        log.info("MonederoMovilService ->  "+monederoMovilDao.toString());
        return monederoMovilRepository.save(monederoMovilDao);
    }

    @Override
    public void saveFromkafka(MonederoMovilDao monederoMovilDao) {
        int randomNumber = Util.generateRandomNumber(1, 100000);
        monederoMovilDao.setFechaCreacion(Util.getCurrentDate());
        monederoMovilDao.setFechaCreacionT(Util.getCurrentDateAsString("yyyy-MM-dd"));
        monederoMovilDao.setNumeroMonedero("AHO".concat(Integer.toString(randomNumber)));
        log.info("monederomovilService ->  "+monederoMovilDao.toString());
        Mono<MonederoMovilDao>  monederoMovilDaoResp =monederoMovilRepository.save(monederoMovilDao);
        monederoMovilDaoResp.subscribe(result -> log.info("Entity has been saved: {}", result));
    }

    @Override
    public Flux<MonederoMovilDao> findAll(Integer limit) {
        return monederoMovilRepository.findAll();
    }
}
