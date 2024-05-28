package tridm.StudentManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.Mail;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromMail;



    public void sendSimpleEmail(String mail, Mail mailStructure) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(mail);
        message.setSubject(mailStructure.getSubject());
        message.setText(mailStructure.getMsg());

        mailSender.send(message);   
    }
}