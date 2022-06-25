package com.training.ducat.model;

import java.util.List;

import com.training.ducat.entity.ProductBrandEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private long id;
	private String name;
	private String desc;
	private long price;
	private long discount;
	private List<ProductBrandEntity> brand;
	private String port;

}
