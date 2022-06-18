package com.training.ducat.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ducat.entity.ProductDetailEntity;
import com.training.ducat.model.ProductDetailDTO;
import com.training.ducat.service.ProductDetailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/product-detail")
@Slf4j
public class ProductDetailController {
	
	private ProductDetailService productService;
	
	public ProductDetailController(ProductDetailService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductDetailEntity>> getList(){
		log.info("An INFO Message");
		return ResponseEntity.status(HttpStatus.FOUND).body(productService.getList());
	}
	
	@GetMapping("/{id}")
	public ProductDetailDTO getId(@PathVariable("id") long id){
		return productService.getById(id);
	}
	
	@PostMapping("/save")
	public ProductDetailEntity save(@RequestBody ProductDetailEntity entity){
		productService.save(entity);
		return entity;
	}
}
