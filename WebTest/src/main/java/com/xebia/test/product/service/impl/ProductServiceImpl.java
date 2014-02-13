package com.xebia.test.product.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.test.common.hibernate.ProductDetailEO;
import com.xebia.test.product.dao.ProductDao;
import com.xebia.test.product.service.ProductService;
import com.xebia.test.product.valueObject.ProductDetail;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductDetail> getAllProducts() {

		return convertEOToVO(productDao.getAllProducts());
	}
	private List<ProductDetail> convertEOToVO(List<ProductDetailEO> productDetailEOs){
		List<ProductDetail> productDetails= null;
		if(productDetailEOs!=null){
			productDetails= new ArrayList<ProductDetail>();
			for (Iterator iterator = productDetailEOs.iterator(); iterator
					.hasNext();) {
				ProductDetailEO productDetailEO = (ProductDetailEO) iterator.next();
				ProductDetail detail = new ProductDetail();
				detail.setAvgPrice(productDetailEO.getAvgPrice());
				detail.setBarCode(productDetailEO.getBarCode());
				detail.setHighestPrice(productDetailEO.getHighestPrice());
				detail.setDescription(productDetailEO.getDescription());
				detail.setLowestPrice(productDetailEO.getLowestPrice());
				detail.setProductName(productDetailEO.getProductName());
				detail.setId(productDetailEO.getId());
				productDetails.add(detail);
			}
		}
		return productDetails;
	}
	
	public boolean addProduct(ProductDetail detail){
		
		return productDao.addProduct(converVOTOEO(detail));
		
	}
	private ProductDetailEO converVOTOEO(ProductDetail detail){
		ProductDetailEO  detailEO = null;
		if(detail!=null){
			detailEO = new ProductDetailEO();
			detailEO.setAvgPrice(detail.getAvgPrice());
			detailEO.setBarCode(detail.getBarCode());
			detailEO.setHighestPrice(detail.getHighestPrice());
			detailEO.setDescription(detail.getDescription());
			detailEO.setId(detail.getId());
			detailEO.setLowestPrice(detail.getLowestPrice());
			detailEO.setProductName(detail.getProductName());
		}
		
		return detailEO;
	
	}
	private ProductDetail converEOTOVO(ProductDetailEO detail){
		ProductDetail  detailEO = null;
		if(detail!=null){
			detailEO = new ProductDetail();
			detailEO.setAvgPrice(detail.getAvgPrice());
			detailEO.setBarCode(detail.getBarCode());
			detailEO.setHighestPrice(detail.getHighestPrice());
			detailEO.setDescription(detail.getDescription());
			detailEO.setId(detail.getId());
			detailEO.setLowestPrice(detail.getLowestPrice());
			detailEO.setProductName(detail.getProductName());
		}
		
		return detailEO;
	
	}
	public List<Double> getPricesOfProduct(long productId) {
		ProductDetail detail=converEOTOVO(productDao.getProductById(productId));
		List<Double> doubles=null;
		if(detail!=null){
			doubles = new ArrayList<Double>();
			doubles.add(detail.getAvgPrice());
			doubles.add(detail.getLowestPrice());
			doubles.add(detail.getHighestPrice());
			
		}
		 Collections.sort(doubles);
		 return doubles;
	}
}
