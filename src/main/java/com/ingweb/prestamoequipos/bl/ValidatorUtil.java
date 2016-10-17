package com.ingweb.prestamoequipos.bl;

/**
 * Clase singleton para manejo de utilidades de validaciòn de campos 
 * @author FranciscoJavier
 *
 */
public class ValidatorUtil {
	
	private static ValidatorUtil instance = null;

	public static ValidatorUtil getInstance(){
		if (instance == null){
			instance = new ValidatorUtil();
		}
		return instance;
	}
	
	public boolean emailValidator(String email){
		return false;		
	}
	/**
	 * Toma una cadena de caracteres elimina los epacio en blanco al incio y al final y valida
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
