package com.ingweb.prestamoequipos.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.prestamoequipos.dao.RolDao;
import com.ingweb.prestamoequipos.model.Rol;

@Service
@Transactional
public class RolBL implements IRolBL{
	
	@Autowired
	private RolDao rolDao;

	public void save(Rol rol) {
		rolDao.save(rol);		
	}

	public void update(Rol rol) {
		// TODO Auto-generated method stub
		
	}

	public List<Rol> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
