package com.qp.assessment.grocery.booking.services;


import com.qp.assessment.grocery.booking.Exceptions.ValidationException;
import com.qp.assessment.grocery.booking.dtos.CustomerOrderDto;
import com.qp.assessment.grocery.booking.dtos.OrderItemsDto;
import com.qp.assessment.grocery.booking.entities.*;
import com.qp.assessment.grocery.booking.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderItemsRepository orderItemsRepository;

    private final GroceryOrderRepository groceryOrderRepository;

    private final UserRepository userRepository;

    private final PaymentDetailsRepository paymentDetailsRepository;

    public CustomerOrderDto createCustomerOrder(CustomerOrderDto customerOrderDto) throws ValidationException{

        log.info("inside createCustomerOrder",customerOrderDto.getCustomerId());
        checkAndAddCustomer(customerOrderDto);
        GroceryOrder groceryOrder=processOrder(customerOrderDto);
        groceryOrder=groceryOrderRepository.save(groceryOrder);
        GroceryOrder finalGroceryOrder = groceryOrder;
        List<OrderItems> orderItemsDtoList=customerOrderDto.getOrderItemsList().stream().map(e->populateOrderItems(e, finalGroceryOrder.getId())).collect(Collectors.toList());
        orderItemsRepository.saveAll(orderItemsDtoList);
        processPayment(customerOrderDto);
        customerOrderDto.setOrderId(finalGroceryOrder.getId());
        customerOrderDto.setOrderStatus(OrderStatus.CREATED);
        return customerOrderDto;


    }

    private void processPayment(CustomerOrderDto customerOrderDto) {

        PaymentDetails details=new PaymentDetails();
        details.setOrderId(customerOrderDto.getOrderId());
        details.setAmount(customerOrderDto.getTotalPrice());
        details.setPaymentStatus(PaymentStatus.PENDING);
        details.setCreatedDate();
        paymentDetailsRepository.save(details);
    }


    private void checkAndAddCustomer(CustomerOrderDto customerOrderDto) throws ValidationException {

        if(ObjectUtils.isEmpty(customerOrderDto.getCustomerId()) && ObjectUtils.isEmpty(customerOrderDto.getCustomerMobile())){
            throw new ValidationException("Order Can't be created");
        }
        if(ObjectUtils.isEmpty(customerOrderDto.getCustomerId())){
            User user=addCustomer(customerOrderDto.getCustomerMobile());
            customerOrderDto.setCustomerId(user.getId());
        }

    }

    private User addCustomer(String customerMobile) {
        User user =new User();
        user.setUserType(UserType.CUSTOMER);
        user.setMobile(customerMobile);
        user.setStatus(Boolean.TRUE);
        user.setCreatedDate();
        return userRepository.save(user);
    }

    private GroceryOrder processOrder(CustomerOrderDto customerOrderDto) {

        GroceryOrder order =new GroceryOrder();
        order.setCustomerId(customerOrderDto.getCustomerId());
        order.setTotalQty(customerOrderDto.getTotalItems());
        order.setTotalAmount(customerOrderDto.getTotalPrice());
        order.setCreatedDate();
        order.setStatus(Boolean.TRUE);
        order.setOrderStatus(OrderStatus.CREATED);

        return order;
    }

    private OrderItems populateOrderItems(OrderItemsDto orderItemsDto,Long orderId){

        OrderItems orderItems=new OrderItems();
        orderItems.setCreatedDate();
        orderItems.setOrderId(orderId);
        orderItems.setGroceryItemId(orderItemsDto.getGroceryItemId());
        orderItems.setMrp(orderItemsDto.getMrp());
        orderItems.setQuantity(orderItemsDto.getQty());
        orderItems.setPurchasePrice(orderItemsDto.getPurchasePrice());
        return orderItems;

    }




}
