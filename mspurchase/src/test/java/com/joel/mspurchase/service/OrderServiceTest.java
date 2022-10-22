package com.joel.mspurchase.service;

import com.joel.mspurchase.models.Order;
import com.joel.mspurchase.models.OrderMock;
import com.joel.mspurchase.repositories.OrderRepository;
import com.joel.mspurchase.services.OrderService;
import com.joel.mspurchase.services.exception.BusinessException;
import com.joel.mspurchase.services.rabbitmq.Producer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private Producer producer;

    private OrderMock mock = new OrderMock();

    @DisplayName("Save order successfully")
    @Test
    void sholdSaveOrderSuccessfully() {

        var orderMok = mock.getOrder();

        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(orderMok);
        Mockito.doNothing().when(producer).sendRequest(Mockito.any(Order.class));

        var savedOrder = orderService.save(orderMok);

        assertEquals(orderMok.getCep(), savedOrder.getCep());
        assertNotNull(savedOrder.getCep());

    }
    @DisplayName("Should fail to find non-existing order")
    @Test
    public void shouldFailToFindNonExistingOrder() {
        var id = 1L;

        Throwable exception = assertThrows(BusinessException.class, () -> {
            orderService.findById(id);
        });
        assertEquals("The id request : " + id + " does not exists in the database", exception.getMessage());

    }



}















