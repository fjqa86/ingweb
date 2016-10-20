package com.ingweb.prestamoequipos.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 * Clase que autentifica el email
 * @author juandavid
 *
 */
public class GmailAuthenticator extends Authenticator {
    String user;
    String pw;
    /**
     * Metodo que autentifica el email
     * @param username
     * @param password
     */
    public GmailAuthenticator (String username, String password)
    {
       super();
       this.user = username;
       this.pw = password;
    }
   public PasswordAuthentication getPasswordAuthentication()
   {
      return new PasswordAuthentication(user, pw);
   }
}
