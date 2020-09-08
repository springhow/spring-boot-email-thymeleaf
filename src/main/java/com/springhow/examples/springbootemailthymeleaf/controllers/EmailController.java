package com.springhow.examples.springbootemailthymeleaf.controllers;

import com.springhow.examples.springbootemailthymeleaf.pojo.User;
import com.springhow.examples.springbootemailthymeleaf.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@Controller
public class EmailController {


    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    @ResponseBody
    public String sendMail(@RequestBody User user) throws MessagingException {
        emailService.sendMail(user);
        return "Email Sent Successfully.!";
    }

}
