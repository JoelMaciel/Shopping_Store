package com.msvalidator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void notificationClientPurchaseSuccessfully(String email) {
        var message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Purchase confirmed");
        message.setText("Congratulations , Your purchase has been confirmed! Soon you will receive your tracking code");
        javaMailSender.send(message);
        log.info("Customer Notified - Purchase Approved Successfully");
    }


}

















