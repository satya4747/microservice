package com.training.ducat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ducat.entity.ProductEntity;
import com.training.ducat.model.ProductDTO;
import com.training.ducat.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/product")
@Slf4j
public class ProductController {
	
	@Value("${msg}")
	String msg;
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductEntity>> getList(){
		log.info("config message:==========={}======",msg);
		log.trace("A TRACE Message");
		log.debug("A DEBUG Message");
		log.info("An INFO Message");
		log.warn("A WARN Message");
		log.error("An ERROR Message");
		return ResponseEntity.status(HttpStatus.FOUND).body(productService.getList());
	}
	
	@GetMapping("/{id}")
	public ProductDTO getId(@PathVariable("id") long id){
		ProductDTO byId = productService.getById(id);
		return byId;
	}
	
	@GetMapping("/feign/{id}")
	public ProductDTO getFeignId(@PathVariable("id") long id){
		return productService.getFeignById(id);
	}
	
	@PostMapping("/save")
	public ProductEntity save(@RequestBody ProductEntity entity){
		productService.save(entity);
		return entity;
	}
}
