package com.ingweb.prestamoequipos.bl;

/**
 * Clase singleton para manejo de utilidades de validaciòn de campos 
 * @author FranciscoJavier
 *
 */
public class ValidatorUtil {
	 private final String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	private static ValidatorUtil instance = null;

	public static ValidatorUtil getInstance(){
		if (instance == null){
			instance = new ValidatorUtil();
		}
		return instance;
	}
	
	/**
	 * Toma una cadena de caracteres y valida si es un email valido
	 * @param email
	 * @return retorna falso si la cadena es un email
	 */
	public boolean emailValidator(String email){
		if(email.matches(email)){
			return false;
		}
		return true;		
	}
	/**
	 * Toma una cadena de caracteres elimina los espacios en blanco al incio y al final y valida
	 * que no sea nula o vacìa
	 * @param s
	 * @return retorna falso si la cadena es valida
	 */
	public boolean stringValidator(String s){
		if (s == null || s.trim().length() == 0){
			return true;
		}
		return false;
	}
}
