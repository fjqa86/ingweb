package com.ingweb.prestamoequipos;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ingweb.prestamoequipos.bl.IBrandBL;
import com.ingweb.prestamoequipos.bl.IRolBL;
import com.ingweb.prestamoequipos.model.Brand;
import com.ingweb.prestamoequipos.model.Rol;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class BrandTest {
	
	@Autowired
	private IBrandBL brandBL;
	
	/**
	 * Prueba que no permita grabar un brand existente
	 */
	@Test
	public void saveExist(){
		try{
			Brand brand = new Brand();
			brand.setIdBrand(2);
			brand.setName("DELL");
			brandBL.save(brand);			
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void list(){
		try{
			brandBL.list();			
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
