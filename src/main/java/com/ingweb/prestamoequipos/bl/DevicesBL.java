package com.ingweb.prestamoequipos.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.prestamoequipos.dao.DeviceDao;
import com.ingweb.prestamoequipos.exception.DaoException;
import com.ingweb.prestamoequipos.exception.ValidationException;
import com.ingweb.prestamoequipos.model.Device;
/**
 * Implementación de la interfaz de la logica del negocio de Device
 * @author juandavid
 *
 */
@Service
@Transactional
public class DevicesBL implements IDevicesBL {

	@Autowired
	private DeviceDao deviceDao;

	public DevicesBL() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void save(Device device) {
		// TODO Auto-generated method stub
		String validacion = device.validate();
		if ("".equals(validacion)) {
			Device BrandEncontrado = deviceDao.findById(device.getIdDevice());
			if(BrandEncontrado != null){
				throw new DaoException("El id del device ya existe.");
			}
			deviceDao.save(device);
		} else {
			throw new ValidationException(validacion);
		}
	}

	@Override
	public void update(Device device) {
		// TODO Auto-generated method stub
		String validacion = device.validate();
		if ("".equals(validacion)) {
			deviceDao.update(device);
		} else {
			throw new ValidationException(validacion);
		}

	}

	@Override
	public List<Device> list() {
		List<Device> devices = deviceDao.list();
		if (devices == null) {
			devices = new ArrayList<>();
		}
		return devices;
	}
	
	

}
