package com.joel.mspurchase.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.mspurchase.MspurchaseApplication;
import com.joel.mspurchase.models.OrderMock;
import com.joel.mspurchase.services.OrderService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
}















