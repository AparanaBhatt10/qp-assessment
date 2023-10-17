package com.qp.assessment.grocery.booking.repositories;

import com.qp.assessment.grocery.booking.entities.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Long> {


}
