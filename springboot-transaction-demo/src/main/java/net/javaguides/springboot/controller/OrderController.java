package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.OrderRequest;
import net.javaguides.springboot.dto.OrderResponse;
import net.javaguides.springboot.service.OrderService;
//import net.javaguides.springboot.service.impl.OrderServiceImpl;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderser;


    @PostMapping
    public ResponseEntity<OrderResponse> placeorder(@RequestBody OrderRequest orderrequest)
    {
        return ResponseEntity.ok(orderser.placeOrder(orderrequest));
    }
    
}
