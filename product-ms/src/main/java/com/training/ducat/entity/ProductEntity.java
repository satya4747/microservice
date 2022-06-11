package com.training.ducat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Repository
@Entity(name = "Product")
@Getter
@Setter
public class ProductEntity{
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@Column(name = "description")
	private String desc;
}
