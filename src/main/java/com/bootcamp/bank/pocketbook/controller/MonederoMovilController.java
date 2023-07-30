package com.bootcamp.bank.pocketbook.controller;

import com.bootcamp.bank.pocketbook.model.MonederoMovilDto;
import com.bootcamp.bank.pocketbook.model.MonederoMovilPost;
import com.bootcamp.bank.pocketbook.model.dao.MonederoMovilDao;
import com.bootcamp.bank.pocketbook.service.MonederoMovilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/monedero")
@Log4j2
@RequiredArgsConstructor
public class MonederoMovilController {

    private final MonederoMovilService monederoMovilService;

    @PostMapping
    public Mono<MonederoMovilDto> createPocketBook(@RequestBody MonederoMovilPost monederoMovilPost) {
        return monederoMovilService.save(this.fromMonederoMovilPostToMonederoMovilDao(monederoMovilPost))
                .map(this::fromMonederoMovilDaoToMonederoMovilDto);
    }

    @GetMapping
    public Flux<MonederoMovilDto> findAll(@RequestParam Integer limit) {
        return monederoMovilService.findAll(limit).map(this::fromMonederoMovilDaoToMonederoMovilDto);
    }


    private MonederoMovilDto fromMonederoMovilDaoToMonederoMovilDto(MonederoMovilDao monederoMovilDao) {
        MonederoMovilDto monederoMovilDto = new MonederoMovilDto();
        BeanUtils.copyProperties(monederoMovilDao,monederoMovilDto);
        return monederoMovilDto;
    }

    private MonederoMovilDao fromMonederoMovilPostToMonederoMovilDao(MonederoMovilPost monederoMovilPost) {
        MonederoMovilDao monederoMovilDao = new MonederoMovilDao();
        BeanUtils.copyProperties(monederoMovilPost,monederoMovilDao);
        return monederoMovilDao;
    }

}
