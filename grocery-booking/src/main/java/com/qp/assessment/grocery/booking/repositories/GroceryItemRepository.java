package com.qp.assessment.grocery.booking.repositories;

import com.qp.assessment.grocery.booking.entities.GroceryItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItems,Long> {

    Page<GroceryItems> findAll(Pageable pageable);


}
