package com.bootcamp.bank.pocketbook.controller;

import com.bootcamp.bank.pocketbook.model.IntercambioP2PTransaccionDto;
import com.bootcamp.bank.pocketbook.model.dao.IntercambioP2PTransaccionDao;
import com.bootcamp.bank.pocketbook.model.monedero.p2p.OperacionP2PAccept;
import com.bootcamp.bank.pocketbook.model.monedero.p2p.OperacionP2PRequest;
import com.bootcamp.bank.pocketbook.service.MonederoP2PService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Clase Monedero P2P
 */
@RestController
@RequestMapping("/monedero/p2p")
@Log4j2
@RequiredArgsConstructor
public class MonederoP2PController {

    private final MonederoP2PService monederoP2PService;

    /**
     * Permite generar una solicitud de intercambio de Monendero P2P
     * compra o venta
     * @param operacionP2PRequest
     * @return
     */
    @PostMapping
    public Mono<IntercambioP2PTransaccionDto> interChangeBootCoins(@RequestBody OperacionP2PRequest operacionP2PRequest) {
        return monederoP2PService.interChangeBootCoins(operacionP2PRequest).map(this::fromIntercambioP2PTransaccionDaoToIntercambioP2PTransaccionDto);
    }

    /**
     * Permite aceptar una solicitud de intercambio de Monedero P2P
     * @param operacionP2PAccept
     * @return
     */
    @PutMapping
    public Mono<IntercambioP2PTransaccionDto> acceptP2PTransaction(@RequestBody OperacionP2PAccept operacionP2PAccept) {
        return monederoP2PService.acceptP2PTransaction(operacionP2PAccept).map(this::fromIntercambioP2PTransaccionDaoToIntercambioP2PTransaccionDto);
    }



    private IntercambioP2PTransaccionDto fromIntercambioP2PTransaccionDaoToIntercambioP2PTransaccionDto(IntercambioP2PTransaccionDao intercambioP2PTransaccionDao) {
        IntercambioP2PTransaccionDto intercambioP2PTransaccionDto = new IntercambioP2PTransaccionDto();
        BeanUtils.copyProperties(intercambioP2PTransaccionDao,intercambioP2PTransaccionDto);
        return intercambioP2PTransaccionDto;
    }


}
