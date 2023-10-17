package com.qp.assessment.grocery.booking.dtos;


import com.qp.assessment.grocery.booking.entities.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CustomerOrderDto {

    private List<OrderItemsDto> orderItemsList;
    private Long totalItems;
    private BigDecimal totalPrice;
    private Long customerId;
    private String customerMobile;
    private OrderStatus orderStatus;
    private Long orderId;


}
