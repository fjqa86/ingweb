package com.ingweb.prestamoequipos.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.prestamoequipos.dao.RolDao;
import com.ingweb.prestamoequipos.exception.DaoException;
import com.ingweb.prestamoequipos.exception.ValidationException;
import com.ingweb.prestamoequipos.model.Rol;

@Service("rolBL")
@Transactional
public class RolBL implements IRolBL {

	@Autowired
	private RolDao rolDao;

	public RolBL() {
		// TODO Auto-generated constructor stub
	}

	public void save(Rol rol) {
		String validacion = rol.validate();
		if ("".equals(validacion)) {
			Rol rolEncontrado = rolDao.findById(rol.getIdRol());
			if(rolEncontrado != null){
				throw new DaoException("El id del rol ya existe.");
			}
			rolDao.save(rol);
		} else {
			throw new ValidationException(validacion);
		}

	}

	public void update(Rol rol) {
		String validacion = rol.validate();
		if ("".equals(validacion)) {
			rolDao.update(rol);
		} else {
			throw new ValidationException(validacion);
		}
	}

	public List<Rol> list() {
		List<Rol> roles = rolDao.list();
		if (roles == null) {
			roles = new ArrayList<>();
		}
		return roles;
	}

}
