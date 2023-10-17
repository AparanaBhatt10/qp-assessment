package com.qp.assessment.grocery.booking.services;


import com.qp.assessment.grocery.booking.dtos.Response;
import com.qp.assessment.grocery.booking.entities.GroceryItems;
import com.qp.assessment.grocery.booking.repositories.GroceryItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerService {


    private final GroceryItemRepository groceryItemRepository;


    public Response<GroceryItems> findAllItems(int pageNo, int pageSize){
        Page<GroceryItems> groceryItemsPage=groceryItemRepository.findAll(PageRequest.of(pageNo,pageSize));
        return  new Response<>(groceryItemsPage);

    }


}
