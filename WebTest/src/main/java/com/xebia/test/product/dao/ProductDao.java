package com.xebia.test.product.dao;

import java.util.List;

import com.xebia.test.common.hibernate.ProductDetailEO;

public interface ProductDao {

	public List<ProductDetailEO> getAllProducts();
	public boolean addProduct(ProductDetailEO detailEO);
	public ProductDetailEO getProductById(long productId) ;
}
