package com.bootcamp.bank.pocketbook.model.dao.repository;

import com.bootcamp.bank.pocketbook.model.dao.IntercambioP2PTransaccionDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonederoInterCambioP2PRepository extends ReactiveMongoRepository<IntercambioP2PTransaccionDao,String> {
}
