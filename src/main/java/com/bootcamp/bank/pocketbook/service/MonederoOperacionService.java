package com.bootcamp.bank.pocketbook.service;

import com.bootcamp.bank.pocketbook.model.dao.MonederoOperacionDao;

public interface MonederoOperacionService {
    void saveFromkafka(MonederoOperacionDao monederoOperacionDao);
}
