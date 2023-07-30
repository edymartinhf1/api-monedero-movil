package com.bootcamp.bank.pocketbook.controller;

import com.bootcamp.bank.pocketbook.model.MonederoMovilPost;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase test kafka
 */
@RestController
@RequestMapping("/test/")
@Log4j2
@RequiredArgsConstructor
public class MessageController {
    @Autowired
    private  KafkaTemplate<String,String> kafkaTemplateMessageRequest;

    private final ObjectMapper objectMapper;

    @PostMapping
    public void publish(@RequestBody MonederoMovilPost monederoMovilPost) {
        log.info("publish");
        try {
            String monederoAsMessage = objectMapper.writeValueAsString(monederoMovilPost);
            kafkaTemplateMessageRequest.send("monederomovil", monederoAsMessage);

        }catch(JsonProcessingException ex){
           log.error(""+ex.getMessage());
        }

    }
}
