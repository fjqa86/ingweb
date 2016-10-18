package com.ingweb.prestamoequipos.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase generica para acceso a datos de de operaciones crud. Recibe una clase en el constructor para su construcción.
 * 
 * @author FranciscoJavier
 * 
 * @param <T> clase base para el manejo del dao
 */

public class GenericDao<T> implements IGenericDao<T>{

    private final SessionFactory sessionFactory;
    private final Class<T> t;
 

    public GenericDao(SessionFactory sessionFactory, Class<T> t) {
		super();
		this.sessionFactory = sessionFactory;
		this.t = t;
	}

	protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
	public void save(T object) {
		getSession().save(object);
		
	}

	public void update(T object) {
		getSession().update(object);
		
	}

	public void findById(String id) {
		getSession().get(t,id);
		
	}

	public List<T> list() {
		Criteria crit = getSession().createCriteria(t);
		return crit.list();
	}

	public List<T> find(Criteria c) {
		return c.list();		
	}

}
