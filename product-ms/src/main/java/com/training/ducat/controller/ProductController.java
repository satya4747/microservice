package com.training.ducat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ducat.entity.ProductEntity;
import com.training.ducat.model.ProductDTO;
import com.training.ducat.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductEntity>> getList(){
		return ResponseEntity.status(HttpStatus.FOUND).body(productService.getList());
	}
	
	@GetMapping("/{id}")
	public ProductDTO getId(@PathVariable("id") long id){
		ProductDTO dto = new ProductDTO();
		dto.setId(11);
		dto.setName("asdf");
		return dto;// productService.getById(id);

	}
}
