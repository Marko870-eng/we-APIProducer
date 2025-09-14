package com.weplus.api_producer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class KafkaProducerServiceTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private KafkaProducerService kafkaProducerService;

    @Test
    void testSendStartSignal_SendsCorrectMessage() {
        // ARRANGE: Simuleer de @Value injectie die niet werkt in unit tests
        ReflectionTestUtils.setField(kafkaProducerService, "startTopic", "start_topic");

        // ACT
        kafkaProducerService.sendStartSignal();

        // ASSERT
        verify(kafkaTemplate).send("start_topic", "startProcessing");
    }
}