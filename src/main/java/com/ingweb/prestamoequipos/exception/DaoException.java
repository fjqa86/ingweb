package com.ingweb.prestamoequipos.exception;

import org.hibernate.HibernateException;
/**
 * Dao para manejar las excepciones
 * @author juandavid
 *
 */
public class DaoException extends HibernateException {

	public DaoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
