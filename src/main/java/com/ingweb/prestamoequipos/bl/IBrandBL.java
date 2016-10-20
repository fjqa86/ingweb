package com.ingweb.prestamoequipos.bl;

import java.util.List;

import com.ingweb.prestamoequipos.model.Brand;

public interface IBrandBL 
{
	public void save(Brand brand);
	
	public void update(Brand brand);
	
	public List<Brand> list();
	
}
