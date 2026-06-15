package com.orderflows.pedidos_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    public String checkStatus(){
        return "O servidor de pedidos está rodando com sucesso!";
    }
}
