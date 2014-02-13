package com.xebia.test.common.hibernate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="Product_Detail")
public class ProductDetailEO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6817375961423822249L;

	@Id
	@GeneratedValue
	private long id;
	
	private String productName;
	private String description;
	private String barCode;
	private Double lowestPrice;
	private Double highestPrice;
	private Double avgPrice;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(Double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public Double getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(Double highestPrice) {
		this.highestPrice = highestPrice;
	}
	public Double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}
	
	
}
