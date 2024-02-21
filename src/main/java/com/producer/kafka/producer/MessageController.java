package com.producer.kafka.producer;

import com.producer.kafka.dto.Message;
import com.producer.kafka.dto.MessageRequest;
import com.producer.kafka.repo.ProductRepo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public Message publish(@RequestBody MessageRequest request) {
        Message message = new Message(request.id(), request.name(), request.price(), request.quantity(), LocalDateTime.now()); // (request.message(), LocalDateTime.now())
        kafkaTemplate.send("transaction", message); // kafkaTemplate.send("bartosz", request.message());
        return message;
    }
}