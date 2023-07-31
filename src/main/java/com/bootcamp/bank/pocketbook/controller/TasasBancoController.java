package com.bootcamp.bank.pocketbook.controller;

import com.bootcamp.bank.pocketbook.model.TasaBancoDto;
import com.bootcamp.bank.pocketbook.model.TasaBancoPost;
import com.bootcamp.bank.pocketbook.model.dao.TasaBancoDao;
import com.bootcamp.bank.pocketbook.service.TasasBancoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Permite la creacion y Manejo de Tasas Monedero P2P
 */
@RestController
@RequestMapping("/monedero/tasas")
@Log4j2
@RequiredArgsConstructor
public class TasasBancoController {

    private final TasasBancoService tasasBancoService;

    /**
     * Permite Registrar tasa P2P
     * @param tasaBancoPost
     * @return
     */
    @PostMapping
    public Mono<TasaBancoDto> createTasa(@RequestBody TasaBancoPost tasaBancoPost) {
        return  tasasBancoService.saveTasa(this.fromTasaBancoPostToTasaBancoDao(tasaBancoPost)).map(this::fromTasaBancoDaoToTasaBancoDto);
    }

    @GetMapping
    public Flux<TasaBancoDto> findAll(){
        return tasasBancoService.findAll().map(this::fromTasaBancoDaoToTasaBancoDto);
    }

    @PutMapping
    public Mono<TasaBancoDto> updateTasa(@RequestBody TasaBancoPost tasaBancoPost) {
        return  tasasBancoService.updateTasa(this.fromTasaBancoPostToTasaBancoDao(tasaBancoPost)).map(this::fromTasaBancoDaoToTasaBancoDto);
    }

    private TasaBancoDto fromTasaBancoDaoToTasaBancoDto(TasaBancoDao tasaBancoDao) {
        TasaBancoDto tasaBancoDto = new TasaBancoDto();
        BeanUtils.copyProperties(tasaBancoDao,tasaBancoDto);
        return tasaBancoDto;
    }

    private TasaBancoDao fromTasaBancoPostToTasaBancoDao(TasaBancoPost tasaBancoPost) {
        TasaBancoDao tasaBancoDao = new TasaBancoDao();
        BeanUtils.copyProperties(tasaBancoPost,tasaBancoDao);
        return tasaBancoDao;
    }

}
