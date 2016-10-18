package com.ingweb.prestamoequipos.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ingweb.prestamoequipos.model.Rol;

public class RolDao extends GenericDao<Rol> {

	public RolDao(SessionFactory sessionFactory) {
	super(sessionFactory,Rol.class);
	}
}
