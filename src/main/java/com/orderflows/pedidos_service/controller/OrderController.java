package com.orderflows.pedidos_service.controller;

import com.orderflows.pedidos_service.dto.OrderRequest;
import com.orderflows.pedidos_service.dto.OrderResponse;
import com.orderflows.pedidos_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }

    @GetMapping
    public List<OrderResponse> listAll(){
        return orderService.getAllOrders();
    }

    @PatchMapping("/{id}/cancel")
    public OrderResponse cancel(@PathVariable Long id){
        return orderService.cancelOrder(id);
    }

}
