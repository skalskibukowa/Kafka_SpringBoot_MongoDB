package com.producer.kafka.dto;

import java.time.LocalDateTime;

public record Message(Integer id, String name, Integer price, Integer quantity, LocalDateTime created) { // (String message, LocalDateTime created)
}
