package com.ingweb.prestamoequipos.dao;

import java.util.List;

import org.hibernate.Criteria;

public interface IGenericDao<T> {
	
	public void save(T object);	
	public void update(T object);
	public void findById(String id);
	public List<T> list();
	public List<T> find(Criteria c);

}
