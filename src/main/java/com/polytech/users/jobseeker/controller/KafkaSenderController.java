package com.polytech.users.jobseeker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class KafkaSenderController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }
}
