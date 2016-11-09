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
	
	public void delete(Integer id);
	/**
	 * Elimina un device de la base de datos solo lògicamente
	 * @param id numero de device a eliminar
	 */
	public List<Device> list();
	/**
	 * Retorna una lista de Brand
	 * @return Device
	 */
}
