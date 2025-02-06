package net.javaguides.springboot.dto;

import lombok.Getter;
import lombok.Setter;
//import net.javaguides.springboot.entity.Order;
//import net.javaguides.springboot.entity.Payment;
@Getter
@Setter
public class OrderResponse {
    private String orderTrackingNumber;
    private String message;
    private String status;
    
}
