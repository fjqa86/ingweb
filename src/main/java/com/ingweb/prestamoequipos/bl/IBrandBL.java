package com.ingweb.prestamoequipos.bl;

import java.util.List;

import com.ingweb.prestamoequipos.model.Brand;

/**
 * Interfaz logica del negocio para la clase Brand
 * @author giovanny gomez @gio96gomez@gmail.com
 *
 */
public interface IBrandBL 
{
	
	public void save(Brand brand);
	/**
	 * Guarda el brand
	 * @param brand
	 * @throws ValidationException
	 * @throws DaoException
	 */

	
	public void update(Brand brand);

	/**
	 * Actualiza el brand
	 * @param brand
	 * @throws ValidationException
	 * @throws DaoException
	 */

	
	public List<Brand> list();
	
	/**
	 * Retorna una lista de Brand
	 * @return brands
	 */
	
}
