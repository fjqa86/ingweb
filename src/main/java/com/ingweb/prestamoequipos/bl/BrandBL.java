package com.ingweb.prestamoequipos.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.prestamoequipos.dao.BrandDao;
import com.ingweb.prestamoequipos.exception.DaoException;
import com.ingweb.prestamoequipos.exception.ValidationException;
import com.ingweb.prestamoequipos.model.Brand;


@Transactional
public class BrandBL implements IBrandBL 
{
	@Autowired
	private BrandDao brandDao;

	public BrandBL() {
		// TODO Auto-generated constructor stub
	}

	public void save(Brand brand) {
		String validacion = brand.validate();
		if ("".equals(validacion)) {
			Brand BrandEncontrado = brandDao.findById(brand.getIdBrand());
			if(BrandEncontrado != null){
				throw new DaoException("El id del brand ya existe.");
			}
			brandDao.save(brand);
		} else {
			throw new ValidationException(validacion);
		}

	}

	public void update(Brand brand) {
		String validacion = brand.validate();
		if ("".equals(validacion)) {
			brandDao.update(brand);
		} else {
			throw new ValidationException(validacion);
		}
	}
	

	public List<Brand> list() {
		List<Brand> brands = brandDao.list();
		if (brands == null) {
			brands = new ArrayList<>();
		}
		return brands;
	}
}
