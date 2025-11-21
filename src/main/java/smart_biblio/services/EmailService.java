package smart_biblio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	 @Autowired
	 private JavaMailSender mailSender;
	 
	  public void sendRegistrationEmail(String messageContent) {
	        String adminEmail = "sikuemedi@gmail.com";

	        SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setTo(adminEmail);
	        mail.setSubject("Nouvelle inscription");
	        mail.setText(messageContent);

	        mailSender.send(mail);
	    }
}
