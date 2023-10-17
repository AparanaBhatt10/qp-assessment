package com.qp.assessment.grocery.booking.dtos;


import com.qp.assessment.grocery.booking.entities.GroceryItems;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemsDto {

    private Long qty;
    private Long groceryItemId;
    private BigDecimal mrp;
    private BigDecimal purchasePrice;

}
