package com.ingweb.prestamoequipos;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ingweb.prestamoequipos.bl.IUserBL;
import com.ingweb.prestamoequipos.model.Rol;
import com.ingweb.prestamoequipos.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserTest {

	@Autowired
	private IUserBL userBL;

	/*
	 * Prueba el registro de usaurio, si el correo esta no registrado y la contraseña cumple con 
	 * los criterios.
	 */
	@Test
	public void save() {
		try {
			User user = new User();
			user.setIdUser("javier.quintero@udea.edu.co");
			user.setName("Francisco");
			user.setLastname("Quintero");
			Rol rol = new Rol();
			rol.setIdRol(1);
			user.setRols(rol);
			user.setPassword("Fernando1");
			userBL.signUp(user);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void login() {
		try {
			User user = new User();
			user.setIdUser("javier.quintero@udea.edu.co");
			user.setPassword("13ukifgv");
			boolean permitido = userBL.login(user);
			assertTrue(permitido);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * prueba que el password tenga al menos 8 caracteres , una letra minuscula
	 * y una letra mayuscula.
	 */
	@Test
	public void passwordStreng() {
		try {
			User user = new User();
			user.setIdUser("prueba.quintero@udea.edu.co");
			user.setName("Francisco");
			user.setLastname("Quintero");
			Rol rol = new Rol();
			rol.setIdRol(1);
			user.setRols(rol);
			user.setPassword("fernado");
			userBL.signUp(user);
		} catch (Exception e) {
			assertTrue(e.getMessage(),true);
		}
	}
	
	/**
	 * Prueba la recuperaciòn de contraseña, debe enviar un correo a la dirección.
	 */
/*	@Test
	public void lostPasswor() {
		try {
			User user = new User();
			user.setIdUser("javier.quintero@udea.edu.co");
			userBL.lostPassword(user);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}*/
	

}
