package com.email.Service;

import com.email.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private  JavaMailSender javaMailSender;

    @Autowired
    public  NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    public void sendNotification(User user)throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(user.getEmail()); // the email to which u wish to send the email
        mail.setFrom("fromEMAIL@gmail.com"); // from which the email needs to be sent
        mail.setText("Hello this has been a fun journey");
        mail.setSubject("Sent via Spring Boot");
        javaMailSender.send(mail);

    }
}
