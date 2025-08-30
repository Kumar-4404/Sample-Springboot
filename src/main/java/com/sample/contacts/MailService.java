package com.sample.contacts;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	public void sendMail() {
        // test method
        System.out.println("JavaMailSender bean injected successfully!");
    }
	

	public void SendMail(String to) {
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("ijji.kumar7@gmail.com");
		msg.setTo(to);
		msg.setSubject("Sample test mail");
		msg.setText("Sample text");
		
		javaMailSender.send(msg);
		
	}
}
