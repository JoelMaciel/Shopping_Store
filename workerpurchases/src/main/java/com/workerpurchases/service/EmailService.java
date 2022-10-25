package com.workerpurchases.service;

import com.workerpurchases.models.Order;
import com.workerpurchases.service.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    private final OrderProducer orderProducer;

    public void notificationClient(Order order) {
        var message = new SimpleMailMessage();
        message.setTo(order.getEmail());
        message.setSubject("Purchase received");
        message.setText("This is a purchase confirmation email received. " +
                "Now we will approve your purchase and shortly you will receive a new confirmation email. " +
                "\nThank you for shopping with us !!");
        javaMailSender.send(message);
        log.info("Customer successfully notified");

        log.info("Preparing producer order....");
        orderProducer.sendOrder(order);
    }


}

















