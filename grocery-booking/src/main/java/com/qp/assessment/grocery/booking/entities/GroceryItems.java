package com.qp.assessment.grocery.booking.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "grocery_items")
@Data
public class GroceryItems extends AbstractEntity{


    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "mrp")
    private BigDecimal mrp;

    @Column(name = "discountPer")
    private BigDecimal discountPer;

    @Column(name = "available_qty")
    private Long availableQty;

    @Column(name = "category_id")
    private Long category;

    @Column(name = "inventory_level")
    @Enumerated(EnumType.STRING)
    private InventoryLevel inventoryLevel;

}
