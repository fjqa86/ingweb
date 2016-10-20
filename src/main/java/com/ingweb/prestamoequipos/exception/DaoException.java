package com.ingweb.prestamoequipos.exception;

import org.hibernate.HibernateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoException extends HibernateException {
	
	 static final Logger logger = LogManager.getLogger();

	public DaoException(String message) {
		super(message);
		logger.error(message);
	}

}
