package com.ingweb.prestamoequipos.bl;
import java.util.List;

import com.ingweb.prestamoequipos.model.Device;

/**
 * Interfaz logica del negocio para la clase Device
 * @author giovanny gomez @gio96gomez@gmail.com
 *
 */
public interface IDevicesBL 
{
	public void save(Device device);
	/**
	 * Guarda el device
	 * @param brand
	 * @throws ValidationException
	 * @throws DaoException
	 */
	public void update(Device device);
	/**
	 * Actualiza el device
	 * @param brand
	 * @throws ValidationException
	 * @throws DaoException
	 */
	
	public List<Device> list();
	/**
	 * Retorna una lista de Brand
	 * @return Device
	 */
}
