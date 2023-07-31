package com.bootcamp.bank.pocketbook.service.impl;

import com.bootcamp.bank.pocketbook.model.dao.MonederoMovilDao;
import com.bootcamp.bank.pocketbook.model.dao.MonederoOperacionDao;
import com.bootcamp.bank.pocketbook.model.dao.repository.MonederoMovilRepository;
import com.bootcamp.bank.pocketbook.model.dao.repository.MonederoOperacionRepository;
import com.bootcamp.bank.pocketbook.service.MonederoOperacionService;
import com.bootcamp.bank.pocketbook.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MonderoOperacionServiceImpl implements MonederoOperacionService {

    private final MonederoOperacionRepository monederoOperacionRepository;

    private final MonederoMovilRepository monederoMovilRepository;
    @Override
    public void saveFromkafka(MonederoOperacionDao monederoOperacionDao) {


        MonederoMovilDao monederoMovilDao =  monederoMovilRepository.findByIdClienteAndNumeroCelular(monederoOperacionDao.getIdCliente(),monederoOperacionDao.getNumeroCelular()).block();
        if (monederoMovilDao!=null) {
            monederoOperacionDao.setNumeroMonedero(monederoMovilDao.getNumeroMonedero());
            monederoOperacionDao.setFechaCreacion(Util.getCurrentDate());
            monederoOperacionDao.setFechaCreacionT(Util.getCurrentDateAsString("yyyy-MM-dd"));
            log.info("monederoOperacionDao ->  " + monederoOperacionDao.toString());

            monederoOperacionRepository.save(monederoOperacionDao)
                    .subscribe(result -> log.info("Entity has been saved: {}", result));
        } else {
            log.info("No se encontro numero de monedero con id cliente "+monederoOperacionDao.getIdCliente()+" y con el numero de celular "+monederoOperacionDao.getNumeroCelular());
        }
    }
}
