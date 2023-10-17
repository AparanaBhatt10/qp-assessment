package com.qp.assessment.grocery.booking.controllers;


import com.qp.assessment.grocery.booking.dtos.CustomerOrderDto;
import com.qp.assessment.grocery.booking.services.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/private/api/v1/create")
    public ResponseEntity<CustomerOrderDto> createCustomerOrder(@RequestBody CustomerOrderDto payload){
        return new ResponseEntity<>(orderService.createCustomerOrder(payload), HttpStatus.OK);
    }






}
