package com.qp.assessment.grocery.booking.repositories;

import com.qp.assessment.grocery.booking.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {
}
