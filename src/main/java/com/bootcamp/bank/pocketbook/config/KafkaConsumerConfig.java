package com.bootcamp.bank.pocketbook.config;


import org.apache.kafka.clients.producer.ProducerConfig;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;


import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    @Value("${spring.kafka.boostrap.servers}")
    private String bootstrapserver;

    /**
     * @return
     */
    public Map<String,Object> consumerConfig(){
        Map<String, Object> props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    /**
     * @return
     */
    //
    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        return new DefaultKafkaConsumerFactory(consumerConfig());
    }

    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> factory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


}
