/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package main.dto;

import main.entity.Order;

/**
 *
 * @author hp
 */
public record TransactionResponse(
         Order order,
            Double amount,
            String transactionId
        ) {

}
