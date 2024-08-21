/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Random;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 * @author hp
 */
@Entity
@Table(name="PAYMENT_TB")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Payment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String paymentStatus = new Random().nextBoolean()?"sucess":"failure";
    private String transactionaId=UUID.randomUUID().toString();
    private Integer orderId;
    private Double amount;
    
}
