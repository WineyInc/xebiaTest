/**
 * 
 */
package com.xebia.test.common.generic.dao;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Interface GenericDao.
 *
 * @author Vinay Kumar
 */

public interface GenericDao {

	/**
	 * Save.
	 *
	 * @param eo the eo
	 * @return the serializable
	 */
	public Serializable save(Object eo);
	
	/**
	 * Save or update.
	 *
	 * @param eo the eo
	 */
	public void saveOrUpdate(Object eo);
		
	/**
	 * Delete.
	 *
	 * @param eo the eo
	 */
	public void delete(Object eo);
	
}
