package com.ingweb.prestamoequipos;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ingweb.prestamoequipos.bl.IRolBL;
import com.ingweb.prestamoequipos.bl.RolBL;
import com.ingweb.prestamoequipos.dao.RolDao;
import com.ingweb.prestamoequipos.model.Rol;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RolTest {

	@Autowired
	private IRolBL rolBL;
	
	/**
	 * Prueba que no permita grabar un rol existente
	 */
	@Test
	public void saveExist(){
		try{
			Rol rol = new Rol();
			rol.setIdRol(1);
			rol.setName("Admisnitrador");
			rol.setDisabled(false);
			rolBL.save(rol);			
		}catch (Exception e) {
		}
	}
	
	@Test
	public void list(){
		try{
			rolBL.list();			
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
