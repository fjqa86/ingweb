package com.ingweb.prestamoequipos.util;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * Clase que envia un email
 * @author juandavid
 *
 */
public class SendEmail {
  private Properties propiedades;
  private Session sesion;

  public SendEmail() {
	  propiedades = System.getProperties();

      // Configuramos el servidor de correo
      propiedades.put("mail.smtp.auth", "true");
      propiedades.put("mail.smtp.starttls.enable", "true");
      propiedades.put("mail.smtp.host", "smtp.gmail.com");
      propiedades.put("mail.smtp.port", "587");
      sesion = Session.getDefaultInstance(propiedades, new GmailAuthenticator("ingwebudea2016@gmail.com", "ingweb2016"));

}
  /**
   * Metodo que envia el correo
   * @param para
   * @param asunto
   * @param cuerpo
   */
  public void enviar(String para, String asunto,String cuerpo){
      Transport transport;
      try {
          MimeMessage mensaje = new MimeMessage(sesion);
          mensaje.setFrom(new InternetAddress("soporte@prestaequipos.com,"));
          mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
          mensaje.setSubject(asunto,"UTF-8");
          BodyPart cuerpoMensaje = new MimeBodyPart();
          cuerpoMensaje.setContent(cuerpo,"text/html");
          Multipart multiparte = new MimeMultipart();
          multiparte.addBodyPart(cuerpoMensaje);  
          mensaje.setContent(multiparte);
          transport = sesion.getTransport("smtp");
          transport.send(mensaje);
          transport.close();
      } catch (MessagingException ex) {
         throw new IllegalArgumentException("No se pudo enviar el correo.");
      }
  }
}
