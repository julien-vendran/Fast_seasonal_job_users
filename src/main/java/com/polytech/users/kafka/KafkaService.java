package com.polytech.users.kafka;

public interface KafkaService {

    void sendMessage(String message, String topicName);

}
