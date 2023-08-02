package com.bootcamp.bank.pocketbook.service;


import com.bootcamp.bank.pocketbook.model.dao.IntercambioP2PTransaccionDao;
import com.bootcamp.bank.pocketbook.model.monedero.p2p.OperacionP2PAccept;
import com.bootcamp.bank.pocketbook.model.monedero.p2p.OperacionP2PRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MonederoP2PService {
    Mono<IntercambioP2PTransaccionDao> interChangeBootCoins(OperacionP2PRequest operacionP2PPost);
    Mono<IntercambioP2PTransaccionDao> acceptP2PTransaction(OperacionP2PAccept operacionP2PAccept);
    Flux<IntercambioP2PTransaccionDao> getAllInterchages();
    Flux<IntercambioP2PTransaccionDao> getAllInterchagesAccepted();

}
