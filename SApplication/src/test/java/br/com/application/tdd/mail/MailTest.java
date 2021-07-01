package br.com.application.tdd.mail;

import br.com.application.domain.Usuario;
import br.com.application.persistence.dao.LoginDao;
import br.com.application.util.EmailUtil;
import org.junit.Test;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {
	
	String password = "123456";
	String logon = "jhullyannoorammos@gmail.com";
	
	LoginDao logindao;
	
	@Test
	public void sendMessage() throws Exception {
		
		Usuario usuario = logindao.getUsuario(logon, password);
		
		Session session = EmailUtil.configuration(usuario);
		
		Address[] to = InternetAddress.parse("jhullyannoorammos@gmail.com, jhullyannoorammos@outlook.com, julianors@saneago.com.br");
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(usuario.getEmail(), usuario.getUsername()));
		message.setRecipients(RecipientType.TO, to);
		message.setContent("asssunto-mail", "text/html; charset=UTF-8");
		message.setSubject("assunto-mail");
		message.setText("Email de teste da aplicação de email");
		Transport.send(message);
		
	}

}
