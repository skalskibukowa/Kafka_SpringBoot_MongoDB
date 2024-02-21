package com.producer.kafka.listeners;



import com.producer.kafka.dto.Message;
import com.producer.kafka.model.Product;
import com.producer.kafka.repo.ProductRepo;
import com.producer.kafka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "transaction",
            groupId = "POS-2" ,
            containerFactory = "factory"
    )
    void listener(Message data) { // void listener(String data) { (Message data)
        System.out.println(data); //data.message() // System.out.println("Listener received " + data + " :D");
    }

    @KafkaListener(
            topics = "transaction_json",
            groupId = "POS-1",
            containerFactory = "factory"
    )
    void consumeJson(Product product) {
        System.out.println(product);
    }

}
