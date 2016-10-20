package com.ingweb.prestamoequipos.dao;

import java.util.List;

import org.hibernate.Criteria;
/**
 * Interfaz para el dao generico
 * @author juandavid
 *
 * @param <T>
 */
public interface IGenericDao<T> {
	
	public void save(T object);	
	public void update(T object);
	public T findById(Object id);
	public List<T> list();
	public List<T> find(Criteria c);

}
