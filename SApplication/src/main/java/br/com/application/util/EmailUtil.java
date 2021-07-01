package br.com.application.util;

import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.application.domain.Usuario;

public class EmailUtil {
	
	public static void sendMessage(Usuario usuario, StringBuilder remetente, Map<String, Object> mail) throws Exception {
		
		Message message = null;
		Session session = null;
		
		try {
			
		session = EmailUtil.configuration(usuario);
		Address[] to = InternetAddress.parse(remetente.toString());
		
		message = new MimeMessage(session);
		message.setFrom(new InternetAddress(usuario.getEmail(), usuario.getUsername()));
		message.setRecipients(RecipientType.TO, to);
		message.setContent(mail.get("content"), "text/html; charset=UTF-8");
		message.setSubject(mail.get("subject").toString());
		message.setText(mail.get("message").toString());
		
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			Transport.send(message);
		}
	}

	public static Session configuration(Usuario usuario) {
		
		Properties properties = new Properties();
		Session session = null;
		
		try {
			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls", "true");
			properties.put("mail.stmp.host", "smtp.gmail.com");
			properties.put("mail.stmp.port", "465");
			properties.put("mail.stmp.socketfactory.port", "465");
			properties.put("mail.stmp.socketfactory.class", "javax.net.ssl.SSLSocketFactory");
			
			session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(
							usuario.getEmail(), 
							usuario.getPassword()
					);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		    return session;
		}
	}

	
	
	public static boolean validation(String email) {

		Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			//System.out.println(email + " é um e-mail válido.");
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
