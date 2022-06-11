package com.training.ducat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.ducat.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long>{
	
}
