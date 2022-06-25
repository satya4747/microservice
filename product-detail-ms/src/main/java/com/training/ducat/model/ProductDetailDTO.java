package com.training.ducat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailDTO {
	private long id;
	private long price;
	private long discount;
	private String port;
}
