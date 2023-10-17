package com.qp.assessment.grocery.booking.services;


import com.qp.assessment.grocery.booking.Exceptions.GenericException;
import com.qp.assessment.grocery.booking.dtos.Response;
import com.qp.assessment.grocery.booking.entities.GroceryItems;
import com.qp.assessment.grocery.booking.repositories.GroceryItemRepository;
import com.qp.assessment.grocery.booking.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import org.springframework.data.domain.Page;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdminService {



    private final GroceryItemRepository groceryItemRepository;


    public Response<GroceryItems> findAllItems(int pageNo, int pageSize){
        Page<GroceryItems> groceryItemsPage=groceryItemRepository.findAll(PageRequest.of(pageNo,pageSize));
        return  new Response<>(groceryItemsPage);

    }

    public Response<String> addOrModify(List<GroceryItems> groceryItems,Long adminId){

        try {

            groceryItems.forEach(p->p.setCreatedBy(adminId));
            groceryItemRepository.saveAll(groceryItems);

        }catch (Exception e){
            log.error("Exception in adding or updating data",e);
            throw new GenericException(e.getMessage());
        }

        return new Response<>(1,"Success");

    }

    public  Response<String> deleteItems(List<Long> itemIds){
          try {

              groceryItemRepository.deleteAllById(itemIds);

          }catch (Exception e){
              log.error("Exception in data deletion ",e);
              throw  new GenericException(e.getMessage());
          }

         return new Response<>(1,"Success");

    }



}
