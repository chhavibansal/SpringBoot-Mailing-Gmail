package com.email.Controller;

import com.email.Entity.User;
import com.email.Service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    NotificationService notificationService;

    @RequestMapping("/register")
    public String register(){
        return "please register";
    }

    @RequestMapping("/access")
    public String successAccess(){
        User user = new User();
        user.setFirstName("dipika");
        user.setLastName("jain");
        user.setEmail("toemail@gmail.com");  // email id to whom the mail needs to be sent

    try{
        notificationService.sendNotification(user);
    }
    catch (MailException e){
        logger.info(e.getMessage());
    }
        return "mail sent successfully";
    }
}
