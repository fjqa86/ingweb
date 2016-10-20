package com.ingweb.prestamoequipos.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Clase util para encriptar string o generar contraseñas aleatrias
 * 
 * @author FranciscoJavier
 *
 */
public class Util {

	/**
	 * Encripta una cadena en sha 356
	 * 
	 * @param cadena
	 * @return retorna una cadena nueva encriptada
	 */
	public static final String encriptString(final String cadena) {
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			sha256.update(cadena.getBytes());
			byte[] digest = sha256.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digest.length; i++) {
				sb.append(String.format("%02x", digest[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {

		}
		return "";
	}

	/**
	 * Genera un password aleatorio con letras y números
	 * 
	 * @return contraseña aleatoria
	 */
	public static String randomPassword() {
		final String caracteres = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitud = caracteres.length();
		Random random = new Random();
		StringBuilder contrasena = new StringBuilder();
		int posicion = 0;
		for (int i = 0; i < 8; i++) {
			posicion = random.nextInt(longitud);
			contrasena.append(caracteres.substring(posicion, posicion + 1));
		}
		return contrasena.toString();
	}

}
