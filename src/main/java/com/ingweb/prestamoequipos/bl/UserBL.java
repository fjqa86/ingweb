package com.ingweb.prestamoequipos.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.prestamoequipos.dao.UserDao;
import com.ingweb.prestamoequipos.exception.DaoException;
import com.ingweb.prestamoequipos.exception.ValidationException;
import com.ingweb.prestamoequipos.model.User;
import com.ingweb.prestamoequipos.util.SendEmail;
import com.ingweb.prestamoequipos.util.Util;
/**
 * Logica de negocio para el usuario , creacion ,recuperacion y cambio de contraseña.
 * @author FranciscoJavier
 *
 */
@Service
@Transactional
public class UserBL implements IUserBL {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * Crea un usario nuevo en la base de datos , si el usario no existe previamente.
	 * @throws DaoException si el correo ya existe 
	 */
	public void signUp(User user) {
		String validacion = user.validate();
		if ("".equals(validacion)) {
			User userEncontrado = userDao.findById(user.getIdUser());
			if (userEncontrado != null){
				throw new DaoException("El correo electrónico ya existe.");
			}
			if(ValidatorUtil.getInstance().passwordStrength(user.getPassword())){
				throw new ValidationException("La contraseña no es lo suficiente mente fuerte por favor revise que contenga al menos un número, una letra mayuscula y una letra minuscula, ademas que sean minimo 8 caracteres.");
			}
			userDao.save(user);
		}else{
			throw new ValidationException(validacion);
		}

	}
	
/**
 * toma el idusario enviado en user y valida que existe si exite envia un correo con la contraseña
 * aletoria si no lanza la excepcion
 * @throws DaoException,ValidationException
 */
	public void lostPassword(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hola ");
		if (ValidatorUtil.getInstance().emailValidator(user.getIdUser())){
			throw new ValidationException("El correo electrónico no es valido.");
		}
		User userEncontrado = userDao.findById(user.getIdUser());
		sb.append(userEncontrado.getName());
		sb.append(" tu nueva contraseña es: ");
		if (userEncontrado == null){
			throw new DaoException("No pudimos encontrar el correo, puedes registrarte.");
		}else{
			String nuevoPass = Util.randomPassword();
			userEncontrado.setPassword(nuevoPass);
			userDao.update(userEncontrado);
			sb.append(nuevoPass);
			new SendEmail().enviar(userEncontrado.getIdUser(), "Recuperación de contraseña",sb.toString());
		}

	}

	public void changePassword(String idUser,String oldPassword,String newPassword) {
		if(ValidatorUtil.getInstance().emailValidator(idUser)){
			throw new ValidationException("El correo electrónico no es valido.");
		}
		if(ValidatorUtil.getInstance().passwordStrength(newPassword)){
			throw new ValidationException("La contraseña no es lo suficiente mente fuerte por favor revise que contenga al menos un número, una letra mayuscula y una letra minuscula, ademas que sean minimo 8 caracteres.");
		}
		User userEncontrado = userDao.findById(idUser);	
		if (userEncontrado == null){
			throw new DaoException("No pudimos encontrar el correo");
		}else{
			if(userEncontrado.getPassword().equals(oldPassword)){
				userEncontrado.setPassword(newPassword);
				userDao.update(userEncontrado);
			}else{
				throw new ValidationException("La contraseña anterior no coincide.");
			}
		}
	}

	public boolean login(User user) {
		if(ValidatorUtil.getInstance().emailValidator(user.getIdUser())){
			throw new ValidationException("El correo electrónico no es valido.");
		}
		if(ValidatorUtil.getInstance().stringValidator(user.getPassword())){
			throw new ValidationException("El password no puede ser vacío");
		}
		User userEncontrado = userDao.findById(user.getIdUser());
		if (userEncontrado.getPassword().equals(user.getPassword())){
			return true;
		}
		return false; 	

	}

}
