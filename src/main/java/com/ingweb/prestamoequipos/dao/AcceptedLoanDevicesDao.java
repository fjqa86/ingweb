package com.ingweb.prestamoequipos.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ingweb.prestamoequipos.exception.DaoException;
import com.ingweb.prestamoequipos.model.AccetedLoanDevices;

public class AcceptedLoanDevicesDao extends GenericDao<AccetedLoanDevices> {

	public AcceptedLoanDevicesDao(SessionFactory sessionFactory) {
		super(sessionFactory, AccetedLoanDevices.class);
		// TODO Auto-generated constructor stub
	}

	public void getNumberLoanByDates(Date init, Date close,String idUser){
		Criteria c = getSession().createCriteria(AccetedLoanDevices.class);
		c.add(Restrictions.gt("dateLoan",init ));
		c.add(Restrictions.lt("dateLoan", close));
		c.add(Restrictions.eq("user.idUser", idUser));
		List lista = c.list();
		if (lista != null && lista.size()>1) {
			throw new DaoException("Hay una solicitud de prestamo que choca con la nueva solicitud.");
		}
		c = getSession().createCriteria(AccetedLoanDevices.class);
		c.add(Restrictions.lt("dateLoan",init ));
		c.add(Restrictions.gt("dateClose", close));
		c.add(Restrictions.eq("user.idUser", idUser));
		lista = c.list();
		if (lista != null && lista.size()>1) {
			throw new DaoException("Hay una solicitud de prestamo que choca con la nueva solicitud.");
		}
		
		c = getSession().createCriteria(AccetedLoanDevices.class);
		c.add(Restrictions.gt("dateClose",init ));
		c.add(Restrictions.lt("dateClose", close));
		c.add(Restrictions.eq("user.idUser", idUser));
		lista = c.list();
		if (lista != null && lista.size()>1) {
			throw new DaoException("Hay una solicitud de prestamo que choca con la nueva solicitud.");
		}
	}
}
