package com.tcs.springbootdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// it will inform to jpa that this class is used for jpa repository.(ORM mapping purpose)
@Table(name = "product_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@Column(name = "pro_id")
	private int productId;
	@Column(name="product_name")
	private String productName;
	private String description;
	private float price;
	private String category;
	// if we are not provideing any annotation like @column then 
	// it will take field name as a column name & will have default size 
	
}
