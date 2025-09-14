package com.weplus.api_producer.controller;

import com.weplus.api_producer.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    private final KafkaProducerService kafkaProducerService;

    public ProcessController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/process")
    public String startProcess() {
        kafkaProducerService.sendStartSignal();
        return "Process started!";
    }
}