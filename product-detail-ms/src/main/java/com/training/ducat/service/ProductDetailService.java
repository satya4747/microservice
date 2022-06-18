package com.training.ducat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ducat.entity.ProductDetailEntity;
import com.training.ducat.model.ProductDetailDTO;
import com.training.ducat.repo.ProductDetailRepo;

@Service
public class ProductDetailService{

	@Autowired
	private ProductDetailRepo productDetailRepo;
	
	public List<ProductDetailEntity> getList() {
		return productDetailRepo.findAll();
	}
	
	public ProductDetailDTO getById(long id) {
		 Optional<ProductDetailEntity> findById = productDetailRepo.findById(id);
		 if(findById.isPresent()) {
			 ProductDetailDTO productDTO = new ProductDetailDTO();
			BeanUtils.copyProperties(findById.get(),productDTO);
			return productDTO;
		 }
		 return null;
	}
	
	public ProductDetailEntity save(ProductDetailEntity entity) {
		productDetailRepo.save(entity);
		return entity;
	}
	
}
