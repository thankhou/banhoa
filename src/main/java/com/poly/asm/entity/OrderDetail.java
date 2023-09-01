package com.poly.asm.entity;



import lombok.Data;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="OderDetails")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    Integer quantity;
    @ManyToOne
    @JoinColumn(name = "ProductId")
    Product product;
    @ManyToOne
    @JoinColumn(name = "OrderId")
    Order order;

}
