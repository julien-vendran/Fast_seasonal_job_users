package com.polytech.users.jobseeker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class KafkaListenerController {

    @KafkaListener(topics = "topicName", groupId = "topicName")
    void listen(String data) {
        log.info("######################################");
        log.info(data);
        log.info("######################################");
    }
}
