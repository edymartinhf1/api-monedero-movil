package com.bootcamp.bank.pocketbook.service.impl;

import com.bootcamp.bank.pocketbook.model.dao.IntercambioP2PTransaccionDao;
import com.bootcamp.bank.pocketbook.model.dao.repository.MonederoMovilRepository;
import com.bootcamp.bank.pocketbook.model.dao.repository.MonederoInterCambioP2PRepository;
import com.bootcamp.bank.pocketbook.model.monedero.p2p.OperacionP2PAccept;
import com.bootcamp.bank.pocketbook.model.monedero.p2p.OperacionP2PRequest;
import com.bootcamp.bank.pocketbook.service.MonederoP2PService;
import com.bootcamp.bank.pocketbook.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class MonederoP2PServiceImpl implements MonederoP2PService {

    private final MonederoInterCambioP2PRepository monederoOperacionP2PRepository;

    private final MonederoMovilRepository monederoMovilRepository;

    /**
     * Permite generar una solicitud de intercambio de bootcoins
     * @param operacionP2PRequest
     * @return
     */
    @Override
    public Mono<IntercambioP2PTransaccionDao> interChangeBootCoins(OperacionP2PRequest operacionP2PRequest) {
        IntercambioP2PTransaccionDao intercambioP2PTransaccionDao=new IntercambioP2PTransaccionDao();
        intercambioP2PTransaccionDao.setNumeroCelularSolicitante(operacionP2PRequest.getNumeroCelular());
        intercambioP2PTransaccionDao.setMonto(operacionP2PRequest.getMonto());
        intercambioP2PTransaccionDao.setModoPago(operacionP2PRequest.getModoPago());
        intercambioP2PTransaccionDao.setFechaCreacion(Util.getCurrentDate());
        intercambioP2PTransaccionDao.setFechaCreacionT(Util.getCurrentDateAsString("yyyy-MM-dd"));
        intercambioP2PTransaccionDao.setTipoTransaccionP2P(operacionP2PRequest.getTipoIntercambioP2P());
        return monederoOperacionP2PRepository.save(intercambioP2PTransaccionDao);
    }

    /**
     * Permite aceptar un requerimiento de intercamnbio P2P
     * -verificar que el usuario aceptante tenga monedero P2P
     * -Obtener
     * @param operacionP2PAccept
     * @return
     */
    @Override
    public Mono<IntercambioP2PTransaccionDao> acceptP2PTransaction(OperacionP2PAccept operacionP2PAccept) {
        log.info("service"+operacionP2PAccept.toString());
        return monederoMovilRepository.findByIdClienteAndNumeroCelular(operacionP2PAccept.getIdClienteAceptante(), operacionP2PAccept.getNumeroCelularAceptante())
                .flatMap(monederoMovilDao -> {
                   log.info("monederoMovilDao "+monederoMovilDao.toString());
                   return monederoOperacionP2PRepository.findById(operacionP2PAccept.getId())
                           .flatMap(operacionP2PTransaccionDao -> {
                               UUID uuid= UUID.randomUUID();
                               String idTransaccion=uuid.toString();
                               operacionP2PTransaccionDao.setFechaAceptacion(Util.getCurrentDate());
                               operacionP2PTransaccionDao.setFechaAceptacionT(Util.getCurrentDateAsString("yyyy-MM-dd"));
                               operacionP2PTransaccionDao.setIdTransaccion(idTransaccion);
                               operacionP2PTransaccionDao.setNumeroCelularAceptante(operacionP2PAccept.getNumeroCelularAceptante());
                               return monederoOperacionP2PRepository.save(operacionP2PTransaccionDao);

                           });
                });
    }

    @Override
    public Flux<IntercambioP2PTransaccionDao> getAllInterchages() {
        return monederoOperacionP2PRepository.findAll();
    }


}
