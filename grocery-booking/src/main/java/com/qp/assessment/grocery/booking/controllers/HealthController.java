package com.qp.assessment.grocery.booking.controllers;


import com.qp.assessment.grocery.booking.dtos.Response;
import com.qp.assessment.grocery.booking.entities.GroceryItems;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {


    @GetMapping("/private/api/v1/up")
    public Response<String> getAllItems(){

       return new Response<>(1,"OK");

    }
}
