package com.training.ducat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ducat.entity.ProductDetailEntity;
import com.training.ducat.model.ProductDetailDTO;
import com.training.ducat.repo.ProductDetailRepo;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductDetailService{
	
	private static int count = 0; 

	@Autowired
	private ProductDetailRepo productDetailRepo;
	
	public List<ProductDetailEntity> getList() {
		return productDetailRepo.findAll();
	} 
	
	//@Retry(name = "default")
	//@Retry(name = "productdetail-api-retry", fallbackMethod = "staticResponse")
	//@CircuitBreaker(name = "default", fallbackMethod = "staticResponse")
	//@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public ProductDetailDTO getById(long id) {
		log.info("count retry {}",count);
		count++;
		/*
		 * if(count <=5) { throw new RuntimeException("not able to access"); }
		 */
		 Optional<ProductDetailEntity> findById = productDetailRepo.findById(id);
		 if(findById.isPresent()) {
			 ProductDetailDTO productDTO = new ProductDetailDTO();
			BeanUtils.copyProperties(findById.get(),productDTO);
			return productDTO;
		 }
		 return null;
	}
	
	public ProductDetailDTO staticResponse(long id, Exception e){
		log.info("static response {}",id);
		ProductDetailEntity productEntity = new ProductDetailEntity();
		productEntity.setDiscount(10);
		return new ProductDetailDTO();
	}

	
	public ProductDetailEntity save(ProductDetailEntity entity) {
		productDetailRepo.save(entity);
		return entity;
	}
	
}
