package com.joel.mspurchase.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.mspurchase.MspurchaseApplication;
import com.joel.mspurchase.models.OrderMock;
import com.joel.mspurchase.services.OrderService;
import com.joel.mspurchase.services.exception.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MspurchaseApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;

    private OrderMock orderMock = new OrderMock();

    @Autowired
    private ObjectMapper mapper;

    private static final String URL_ORDER = "/orders";

    @DisplayName("POST - Should register a new order in the database")
    @Test
    public void shouldRegisterNewOrderInTheDatabase() throws Exception {
        var mockId = 1L;
        var orderBody = orderMock.getOrder();

        mockMvc.perform(post(URL_ORDER)
                        .content(mapper.writeValueAsString(orderBody))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        var orderSalved = orderService.findById(mockId);

        assertEquals(orderSalved.getId(), mockId);
        assertNotNull(orderSalved);
    }

    @DisplayName("GET - Should successfully fetch orderId from database")
    @Test
    public void shouldReturnOrderByIdSuccessfully() throws Exception {
        var mockId = 1L;
        mockMvc.perform(get(URL_ORDER.concat("/" + mockId)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @DisplayName("GET - Should fail to fetch order that does not exist")
    @Test
    public void shouldFailToFetchOrderThatDoesNorExist() throws Exception {
        var mockId = 1L;

        mockMvc.perform(get(URL_ORDER.concat("/" + mockId)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    @DisplayName("DELETE - Should successfully delete the order")
    @Test
    public void shouldSuccessfullyDeleteTheOrder() throws Exception {
        var mockId = 1L;
        mockMvc.perform(delete(URL_ORDER.concat("/" + mockId)))
                .andDo(print())
                .andExpect(status().isNoContent());

        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
            orderService.delete(mockId);
        });

        assertEquals("The id request : " + mockId + " does not exists in the database" , exception.getMessage());

    }
}















