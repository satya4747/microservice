package com.training.ducat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.ducat.entity.ProductDetailEntity;

public interface ProductDetailRepo extends JpaRepository<ProductDetailEntity, Long>{
	
}
