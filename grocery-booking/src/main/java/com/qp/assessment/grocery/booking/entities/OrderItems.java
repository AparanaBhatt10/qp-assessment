package com.qp.assessment.grocery.booking.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
public class OrderItems extends AbstractEntity{


    @Column(name="order_id")
    private Long orderId;

    @Column(name="qty")
    private Long quantity;

    @Column(name="grocery_item_id")
    private Long groceryItemId;

    @Column(name = "mrp")
    private BigDecimal mrp;

    @Column(name = "purchasePrice")
    private BigDecimal purchasePrice;

}
