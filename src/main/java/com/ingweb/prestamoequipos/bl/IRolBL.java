package com.ingweb.prestamoequipos.bl;

import java.util.List;

import com.ingweb.prestamoequipos.model.Rol;

public interface IRolBL {

	public void save(Rol rol);
	/**
	 * Guarda el rol
	 * @param rol
	 * @throws ValidationException
	 * @throws DaoException
	 */
	
	public void update(Rol rol);
	/**
	 * Actualiza el rol
	 * @param rol
	 * @throws ValidationException
	 * @throws DaoException
	 */
	
	public List<Rol> list();
	/**
	 * Retorna una lista de Roles
	 * @return Rol
	 */
}
