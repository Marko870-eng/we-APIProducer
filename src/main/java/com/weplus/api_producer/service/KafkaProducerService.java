package com.weplus.api_producer.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final String startTopic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(@Value("${kafka.topic.start}") String startTopic,
                                KafkaTemplate<String, String> kafkaTemplate) {
        this.startTopic = startTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStartSignal() {
        kafkaTemplate.send(startTopic, "startProcessing");
    }
}