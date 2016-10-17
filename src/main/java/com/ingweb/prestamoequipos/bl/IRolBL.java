package com.ingweb.prestamoequipos.bl;

import java.util.List;

import com.ingweb.prestamoequipos.model.Rol;

public interface IRolBL {

	public void save(Rol rol);
	
	public void update(Rol rol);
	
	public List<Rol> list();
}
