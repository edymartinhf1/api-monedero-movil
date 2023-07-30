package com.bootcamp.bank.pocketbook.consumer;

import com.bootcamp.bank.pocketbook.model.MonederoOperacionPost;
import com.bootcamp.bank.pocketbook.service.MonederoOperacionService;
import com.bootcamp.bank.pocketbook.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Log4j2
@RequiredArgsConstructor
public class KafkfaMonederoOperacionListener {

    private final ObjectMapper objectMapper;

    private final MonederoOperacionService monederoOperacionService;

    @KafkaListener(
            topics = "monederooperacionmovil",
            groupId = "groupId"
    )
    public void consumerMonederoOperacionMovil(String tramaKafka) {
        MonederoOperacionPost monederoOperacionPost=null;
        try {
            monederoOperacionPost = objectMapper.readValue(tramaKafka, MonederoOperacionPost.class);
            log.info("monederoOperacionPost "+monederoOperacionPost.toString());
            Mono<MonederoOperacionPost> monederoOperacionMovil= Mono.just(monederoOperacionPost);
            monederoOperacionService.saveFromkafka(Util.fromMonederoOperacionPostToMonederoOperacionDao(monederoOperacionPost));
        }catch(JsonProcessingException ex){
            log.error(ex.getMessage());
        }

    }
}
