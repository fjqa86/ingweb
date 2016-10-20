package com.ingweb.prestamoequipos.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ingweb.prestamoequipos.model.User;
/**
 * Extiende de la clase GenericDao
 * @author juandavid
 *
 */
public class UserDao extends GenericDao<User> {

	public UserDao(SessionFactory sessionFactory) {
		super(sessionFactory,User.class);
	}
}
