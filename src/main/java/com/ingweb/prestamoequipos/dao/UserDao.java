package com.ingweb.prestamoequipos.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ingweb.prestamoequipos.model.User;

public class UserDao extends GenericDao<User> {

	public UserDao(SessionFactory sessionFactory) {
		super(sessionFactory,User.class);
	}
}
