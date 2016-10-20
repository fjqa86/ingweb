package com.ingweb.prestamoequipos.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.ingweb.prestamoequipos.model.Brand;
import com.ingweb.prestamoequipos.dao.BrandDao;
import com.ingweb.prestamoequipos.exception.DaoException;
import com.ingweb.prestamoequipos.exception.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implementacion de la interfaz de la logica del negocio de Brand
 * @author giovanny gomez @gio96gomez@gmail.com
 *
 */


@Service
@Transactional
public class BrandBL implements IBrandBL {

	
	@Autowired
	private BrandDao brandDao;

	public BrandBL() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void save(Brand brand) {
		// TODO Auto-generated method stub
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

	@Override
	public void update(Brand brand) {
		// TODO Auto-generated method stub
		String validacion = brand.validate();
		if ("".equals(validacion)) {
			brandDao.update(brand);
		} else {
			throw new ValidationException(validacion);
		}

	}

	@Override
	public List<Brand> list() {
		List<Brand> brands = brandDao.list();
		if (brands == null) {
			brands = new ArrayList<>();
		}
		return brands;
	}

}
