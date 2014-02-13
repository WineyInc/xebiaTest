/**
 * 
 */
package com.xebia.test.common.generic.dao.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xebia.test.common.generic.dao.GenericDao;

/**
 * @author Vinay Kumar
 *
 */
@Repository
public class GenericDaoImpl implements GenericDao {
	
	private final Logger logger = Logger.getLogger(GenericDaoImpl.class);
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	
	/**
	 *  save object to database
	 *  
	 *  @return Serializable (id) 
	 */
	@Override
	public Serializable save(Object eo) {

		logger.info("inside save method of GenericDaoImpl");
		
		Session session = null;
		Serializable id = null;
		try{
			session = sessionFactory.openSession();
			id = session.save(eo);
			if(session!=null){
				session.flush();
			}
		}catch (Exception e) {
			logger.error("Exception in save :",e);
			
		}finally{
			try {
				if(session!= null){
					session.close();
				}
			} catch (Exception e2) {
				logger.error("Exception while closing hibernate session",e2);
			
			}
		}
		return id;
	}

	@Override
	public void saveOrUpdate(Object eo)  {
		logger.info("inside saveOrUpdate method of GenericDaoImpl");
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.saveOrUpdate(eo);
			if(session!=null){
				session.flush();
			}
		}catch (Exception e) {
			logger.error("Exception in saveOrUpdate:",e);
		}finally{
			try {
				if(session!= null){
					session.close();
				}
			} catch (Exception e2) {
				logger.error("Exception while closing hibernate session",e2);
				System.out.println(e2 +" "+" exception caught while closing session");
			}
		}
	}

	@Override
	public void delete(Object eo) {
		logger.info("inside delete method of GenericDaoImpl");
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.delete(eo);
			if(session!=null){
				session.flush();
			}
		}catch (Exception e) {
			logger.error(e+" "+ "Exeception in delete method");
		}
		finally{
			try {
				if(session!= null){
					session.close();
				}
			} catch (Exception e2) {
				logger.error("Exception while closing hibernate session",e2);
			}
		}		
	}
	
	

}
