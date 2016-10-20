package com.ingweb.prestamoequipos.dao;

import org.hibernate.SessionFactory;

import com.ingweb.prestamoequipos.model.Brand;

public class BrandDao extends GenericDao<Brand> {

	public BrandDao(SessionFactory sessionFactory) {
		super(sessionFactory,Brand.class);
	}
	

}
