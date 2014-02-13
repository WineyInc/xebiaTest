package com.xebia.test.product.command;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductCommand {

	
	@NotEmpty
	private String productName;
	@NotEmpty
	private String description;
	private String barCode;
	@NotEmpty
	private String lowestPrice;
	@NotEmpty
	private String highestPrice;
	@NotEmpty
	private String avgPrice;

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
	public String getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(String lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public String getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(String highestPrice) {
		this.highestPrice = highestPrice;
	}
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
	

}
