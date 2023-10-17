package com.qp.assessment.grocery.booking.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "grocery_orders")
@Data
public class GroceryOrder extends AbstractEntity{

    @Column(name = "total_amount")
    private BigDecimal totalAmount;


    @Column(name = "total_qty")
    private Long totalQty;

    @Column(name = "customer_id")
    private Long customerId;



    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE},
            orphanRemoval = true
    )
    @Fetch(FetchMode.JOIN)
    @JoinColumn(
            name = "order_id",
            insertable = false
    )
    private List<PaymentDetails> paymentDetails;


    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE},
            orphanRemoval = true
    )
    @Fetch(FetchMode.JOIN)
    @JoinColumn(
            name = "order_id",
            insertable = false
    )
    private List<OrderItems> orderItemsList;
}
