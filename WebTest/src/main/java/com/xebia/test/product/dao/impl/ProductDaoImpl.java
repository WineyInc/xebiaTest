package com.xebia.test.product.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xebia.test.common.generic.dao.GenericDao;
import com.xebia.test.common.hibernate.ProductDetailEO;
import com.xebia.test.product.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao {

	private final Logger logger = Logger.getLogger(ProductDaoImpl.class);

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private GenericDao genericDao;

	private final String EO_PREFIX="from com.xebia.test.common.hibernate.";

	@Override
	public List<ProductDetailEO> getAllProducts() {

		Session session= null;
		try{
			session=sessionFactory.openSession();

			Query query=session.createQuery(EO_PREFIX+"ProductDetailEO ");
			List<ProductDetailEO> productDetailEOs=query.list();
			if(productDetailEOs!=null && productDetailEOs.size()>0){
				return productDetailEOs;	
			}
		}
		catch(Exception e){
			logger.error("", e);
		}
		finally{
		
			try{
				session.close();
			}
			catch(Exception t){
				
			}
		}
		
		return null;
	}

	public boolean addProduct(ProductDetailEO detailEO){
		try{
			if(detailEO!=null){
				genericDao.save(detailEO);
				return true;
			}
			return false;
		}
		catch(Exception e){
			logger.error("", e);
		}
		return false;
	}
	public ProductDetailEO getProductById(long productId) {
		Session session= null;
		List<Double> doubles=null;
		try{
			session=sessionFactory.openSession();

			Query query=session.createQuery(EO_PREFIX+"ProductDetailEO where id="+productId);
			List<ProductDetailEO> productDetailEOs=query.list();
			if(productDetailEOs!=null && productDetailEOs.size()>0){
				return productDetailEOs.get(0); 	
			}
		}
		catch(Exception e){
			logger.error("", e);
		}
		finally{
		
			try{
				session.close();
			}
			catch(Exception t){
				
			}
		}
		
		return null;
	}
}
