package com.portfolio.controller;

import com.portfolio.modal.Product;
import com.portfolio.repository.ProductRepository;
import com.portfolio.resource.ProductRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {
	
	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(this.productRepository.findAll());
	}
	
	@PostMapping("saveProduct")
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		return ResponseEntity.ok(this.productRepository.save(product));
	}
	

}
