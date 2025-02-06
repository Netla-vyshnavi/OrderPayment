package net.javaguides.springboot.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.Repository.OrderRepository;
import net.javaguides.springboot.Repository.PaymentRepository;
import net.javaguides.springboot.dto.OrderRequest;
import net.javaguides.springboot.dto.OrderResponse;
import net.javaguides.springboot.entity.Order;
import net.javaguides.springboot.entity.Payment;
import net.javaguides.springboot.exception.PaymentException;
import net.javaguides.springboot.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    public OrderRepository orderRepo;

    @Autowired
    public PaymentRepository paymentRepo;

    @Override
    @Transactional(rollbackFor = PaymentException.class)
    public OrderResponse placeOrder(OrderRequest orderRequest)
    {
         Order order=orderRequest.getOrder();
         order.setStatus("In Progress");
         order.setOrderTrackingNumber(UUID.randomUUID().toString());
         orderRepo.save(order);

         Payment payment=orderRequest.getPayment();

         if(!payment.getType().equals("Debit"))
         {
            throw new PaymentException("Card Type is not supported");
         }

          payment.setOrderId(order.getId());
          paymentRepo.save(payment);

          OrderResponse orderResponse=new OrderResponse();
          orderResponse.setMessage("Order is Successful");
          orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
          orderResponse.setStatus(order.getStatus());

          return orderResponse;
 
    }
}
