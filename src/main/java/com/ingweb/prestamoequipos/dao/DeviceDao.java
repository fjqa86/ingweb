package com.ingweb.prestamoequipos.dao;

import org.hibernate.SessionFactory;

import com.ingweb.prestamoequipos.model.Device;
/**
 * Extiende de la clase GenericDao
 * @author juandavid
 *
 */
public class DeviceDao extends GenericDao<Device> {

	public DeviceDao(SessionFactory sessionFactory) {
		super(sessionFactory,Device.class);
	}
}
