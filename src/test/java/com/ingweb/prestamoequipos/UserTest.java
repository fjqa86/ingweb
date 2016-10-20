package com.ingweb.prestamoequipos;

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
			fail(e.getMessage());
		}
	}
	
	/**
	 * prueba que el password tenga al menos 8 caracteres , una letra minuscuyla
	 * y una letra mayuscula
	 */
	@Test
	public void passwordStreng() {
		try {
			User user = new User();
			user.setIdUser("javier.quintero@udea.edu.co");
			user.setName("Francisco");
			user.setLastname("Quintero");
			Rol rol = new Rol();
			rol.setIdRol(1);
			user.setRols(rol);
			user.setPassword("fernado");
			userBL.signUp(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
