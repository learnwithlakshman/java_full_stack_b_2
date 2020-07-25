package com.lwl.sms;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class SmsApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//		helper.setTo("lakshman.miani@gmail.com");
//		helper.setFrom("lakshman.miani@gmail.com");
//		helper.setText(String.format("<html>\n" + 
//				"<head>\n" + 
//				"<title>%s</title>\n" + 
//				"<body>\n" + 
//				"Dear : %s\n" + "ಸ್ವಾತಂತ್ರ್ಯ ದಿನಾಚರಣೆ ಸನ್ನಿಹಿತವಾಗುತ್ಇದ್ದು, ಆಚರಣೆಯಿಂದ ದೂರವಿರುವಂತೆ ದೇಶದ ಜನರಲ್ಲಿ ಮನವಿ ಮಾಡಿಕೊಳ್ಳಲಾಗಿದೆ. ಸಾಮಾಜಿಕ ಅಂತರವನ್ನು ಕಾಯ್ದುಕೊಳ್ಳುವುದು ಎಲ್ಲರ ಜವಾಬ್ದಾರಿಯಾಗಿದೆ."	+"<p>\n" + 
//				"  %s\n" + 
//				"</p>\n" + 
//				"</body>\n" + 
//				"</html>","Greetings from LWL","Naidu","Happy Independence Day"),true);
//		helper.setSubject("Java Mail Greetings");
//		helper.addAttachment("spring-boot.png",new ClassPathResource("spring-boot.png") );
//		javaMailSender.send(mimeMessage);

	}

}
