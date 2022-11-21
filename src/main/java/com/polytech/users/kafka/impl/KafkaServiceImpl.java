package com.polytech.users.kafka.impl;

import com.polytech.users.kafka.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }
}
