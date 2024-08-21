/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package main.dto;

import java.util.Random;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 *
 * @author hp
 */
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Payment {
    private Integer id;
    private String paymentStatus = new Random().nextBoolean()?"sucess":"failure";
    private String transactionaId=UUID.randomUUID().toString();
    private Integer orderId;
    private Double amount;
}
