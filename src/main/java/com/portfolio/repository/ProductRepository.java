package com.portfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.portfolio.modal.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
