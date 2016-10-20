package com.ingweb.prestamoequipos.dao;

import org.hibernate.SessionFactory;

import com.ingweb.prestamoequipos.model.Brand;
/**
 * Extiende de la clase GenericDao
 * @author juandavid
 *
 */
public class BrandDao extends GenericDao<Brand> {

	public BrandDao(SessionFactory sessionFactory) {
		super(sessionFactory,Brand.class);
	}
	

}
