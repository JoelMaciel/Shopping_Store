package com.msvalidator.service;

import com.msvalidator.models.Card;
import com.msvalidator.models.Order;
import com.msvalidator.service.exception.InsufficientBalanceException;
import com.msvalidator.service.exception.LimitUnavailableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.LineUnavailableException;

@Log4j2
@Service
public class ValidatorService {

    @Autowired
    private EmailService emailService;

    public void validateOrder(Order order) {
        validateAvailableLimit(order.getCard());
        validatePurchaseWithLimit(order);
        emailService.notificationClientPurchaseSuccessfully(order.getEmail());
    }

    private void validatePurchaseWithLimit(Order order) {
        if(order.getValueProduct().longValue() > order.getCard().getAvailableLimit().longValue()) {
            log.error("Value of the order : {} . Limit available : {} ", order.getValueProduct(), order.getCard().getAvailableLimit());
            throw new InsufficientBalanceException("You have no limit to make this purchase");
        }
    }

    private void validateAvailableLimit(Card card) {
        if(card.getAvailableLimit().longValue() <= 0) {
            throw new LimitUnavailableException("Limit unavailable.");
        }
    }
}
