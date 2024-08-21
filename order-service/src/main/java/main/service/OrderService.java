/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import main.dto.Payment;
import main.dto.TransactionRequest;
import main.dto.TransactionResponse;
import main.repo.OrderRepo;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 *
 * @author hp
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal=true,level=AccessLevel.PRIVATE)
public class OrderService {
    OrderRepo repo;
    @LoadBalanced
    RestClient client = RestClient.create("http://payment-service/api/payments");
    
    public TransactionResponse saveOrder(TransactionRequest request){
        var order= request.order();
        var payment = request.payment().setAmount(order.getPrice());
        var savedOrder = repo.save(order);
        payment.setOrderId(savedOrder.getId());
        var savedPayment = client.post().body(payment).retrieve().toEntity(Payment.class).getBody();
        return new TransactionResponse(savedOrder, savedPayment.getAmount(),savedPayment.getTransactionaId());
    }
    
    
}
