package com.msvalidator.service;

import com.msvalidator.models.Card;
import com.msvalidator.models.Order;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ValidatorService {
    public void validateOrder(Order order) throws Exception {
        validateAvailableLimit(order.getCard());
        validatePurchaseWithLimit(order);
    }

    private void validatePurchaseWithLimit(Order order) throws Exception {
        if(order.getValueProduct().longValue() > order.getCard().getAvailableLimit().longValue()) {
            log.error("Value of the order : {} . Limit available : {} ", order.getValueProduct(), order.getCard().getAvailableLimit());
            throw new Exception("You have no limit to make this purchase");
        }
    }

    private void validateAvailableLimit(Card card) throws Exception {
        if(card.getAvailableLimit().longValue() <= 0) {
            throw new Exception("Limit unavailable.");
        }
    }
}
