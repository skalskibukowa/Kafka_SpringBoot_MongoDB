package com.producer.kafka.dto;

public record MessageRequest(Integer id, String name, Integer price, Integer quantity) { //  (String message)
}
