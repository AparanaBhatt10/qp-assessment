package com.qp.assessment.grocery.booking.controllers;


import com.qp.assessment.grocery.booking.dtos.Response;
import com.qp.assessment.grocery.booking.entities.GroceryItems;
import com.qp.assessment.grocery.booking.services.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
@Slf4j
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/private/api/v1/items/{pageNo}/{pageSize}")
    public Response<GroceryItems> getAllItems(@PathVariable Integer pageNo,@PathVariable Integer pageSize){

        return adminService.findAllItems(pageNo,pageSize);

    }

    @PutMapping("/private/api/v1/items/{adminId}")
    public Response<String> updateItems( @RequestBody List<GroceryItems> updateList,@PathVariable Long adminId){

        return adminService.addOrModify(updateList,adminId);

    }

    @PostMapping("/private/api/v1/items/add/{adminId}")
    public Response<String> addItems( @RequestBody List<GroceryItems> updateList,@PathVariable Long adminId){

        return adminService.addOrModify(updateList,adminId);

    }

    @DeleteMapping("/private/api/v1/items/remove/{adminId}")
    public Response<String> deleteItems(@RequestBody List<Long> deleteList){

        return adminService.deleteItems(deleteList);

    }










}
