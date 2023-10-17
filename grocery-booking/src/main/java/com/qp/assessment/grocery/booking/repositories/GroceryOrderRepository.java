package com.qp.assessment.grocery.booking.repositories;

import com.qp.assessment.grocery.booking.entities.GroceryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroceryOrderRepository extends JpaRepository<GroceryOrder,Long> {
}
