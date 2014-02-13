/**
 * 
 */
package com.xebia.test.product.service;

import java.util.List;

import com.xebia.test.product.valueObject.ProductDetail;

/**
 * @author Lalit
 *
 */
public interface ProductService {

	public List<ProductDetail> getAllProducts();
	public boolean addProduct(ProductDetail detail);
	public List<Double> getPricesOfProduct(long productId) ;
}
