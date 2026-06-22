package com.orderflows.pedidos_service.service;

import com.orderflows.pedidos_service.dto.OrderRequest;
import com.orderflows.pedidos_service.dto.OrderResponse;
import com.orderflows.pedidos_service.model.Order;
import com.orderflows.pedidos_service.model.OrderStatus;
import com.orderflows.pedidos_service.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    @DisplayName("Should create an order with success")
    void shouldCreateOrderWithSuccess(){
        // Given
        OrderRequest request = new OrderRequest();
        request.setCustomerName("Elon Musk");
        request.setTotalAmount(new BigDecimal("500.00"));

        Order orderSaved = new Order();
        orderSaved.setId(1L);
        orderSaved.setCustomerName("Elon Musk");
        orderSaved.setStatus(OrderStatus.PENDING);

        // When
        when(orderRepository.save(any(Order.class))).thenReturn(orderSaved);

        OrderResponse response = orderService.createOrder(request);

        // Then
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals(OrderStatus.PENDING, response.getStatus());

        verify(orderRepository, times(1)).save(any(Order.class));
    }
}