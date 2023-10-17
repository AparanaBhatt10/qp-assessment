package com.qp.assessment.grocery.booking.controllers;


import com.qp.assessment.grocery.booking.dtos.Response;
import com.qp.assessment.grocery.booking.entities.GroceryItems;
import com.qp.assessment.grocery.booking.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer")
@Slf4j
public class CustomerController {


    private final CustomerService customerService;

    @GetMapping("/private/api/v1/items/{pageNo}/{pageSize}")
    public Response<GroceryItems> getAllItems(@PathVariable Integer pageNo, @PathVariable Integer pageSize){

        return customerService.findAllItems(pageNo,pageSize);

    }
}
