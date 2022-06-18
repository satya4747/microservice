package com.training.ducat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.ducat.entity.ProductEntity;
import com.training.ducat.model.ProductDTO;
import com.training.ducat.repo.ProductRepo;

@Service
public class ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	ProductDetailTemplate detailTemplate;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${product-detail-byId-URL:http://localhost:9091/v1/product-detail/}")
	String productDetailbyIdURL;
	
	public List<ProductEntity> getList() {
		return productRepo.findAll();
	}
	
	public ProductDTO getById(long id) {
		 Optional<ProductEntity> findById = productRepo.findById(id);
		 if(findById.isPresent()) {
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(findById.get(),productDTO);
			
			ProductDTO proDetail = restTemplate.getForObject(productDetailbyIdURL+id, productDTO.getClass());
			productDTO.setDiscount(proDetail.getDiscount());
			productDTO.setPrice(proDetail.getPrice());
			return productDTO;
		 }
		 return null;
	}
	
	
	public ProductDTO getFeignById(long id) {
		 Optional<ProductEntity> findById = productRepo.findById(id);
		 if(findById.isPresent()) {
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(findById.get(),productDTO);
			
			ProductDTO proDetail = detailTemplate.getDetail(id);
			productDTO.setDiscount(proDetail.getDiscount());
			productDTO.setPrice(proDetail.getPrice());
			return productDTO;
		 }
		 return null;
	}
	
	public ProductEntity save(ProductEntity entity) {
		productRepo.save(entity);
		return entity;
	}
	
}
