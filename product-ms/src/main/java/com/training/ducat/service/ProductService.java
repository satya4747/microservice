package com.training.ducat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ducat.entity.ProductEntity;
import com.training.ducat.model.ProductDTO;
import com.training.ducat.repo.ProductRepo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class ProductService extends BaseService{

	@Autowired
	private ProductRepo productRepo;
	
	public List<ProductEntity> getList() {
		return productRepo.findAll();
	}
	
	
	public ProductDTO getById(long id) {
		 Optional<ProductEntity> findById = productRepo.findById(id);
		 if(findById.isPresent()) {
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(findById.get(),productDTO);
			return productDTO;
		 }
		 return null;
	}
	
	
	
}
