package com.producer.kafka.service;


import com.producer.kafka.model.Product;

import java.util.List;

public interface ProductService {

     List<Product> getProducts();

     Product addProduct(Product product);

     Product deleteProduct(int id );

     Product updateProduct(int id , Product product);
}