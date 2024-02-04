package com.email.demo.service;

import com.email.demo.dto.request.Email;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendMail(Email email) throws MessagingException {
        var msg = javaMailSender.createMimeMessage();
        var helper = new MimeMessageHelper(msg, false);

        helper.setFrom(email.getFrom());
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        helper.setText(email.getContent(), true);

        javaMailSender.send(msg);
    }
}
