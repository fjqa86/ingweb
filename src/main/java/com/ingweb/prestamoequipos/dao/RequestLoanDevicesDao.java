package com.ingweb.prestamoequipos.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ingweb.prestamoequipos.model.RequestLoanDevices;
/**
 * Extiende de la clase GenericDao
 * @author juandavid
 *
 */
public class RequestLoanDevicesDao extends GenericDao<RequestLoanDevices> {

	public RequestLoanDevicesDao(SessionFactory sessionFactory) {
		super(sessionFactory,RequestLoanDevices.class);
	}

	public List<RequestLoanDevices> pendingRequest(){
		Criteria c = getSession().createCriteria(RequestLoanDevices.class);
		c.add(Restrictions.isNull("approved"));
		return find(c);
	}
}
