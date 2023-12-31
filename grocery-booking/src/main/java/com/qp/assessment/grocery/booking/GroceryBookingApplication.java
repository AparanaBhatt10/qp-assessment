package com.qp.assessment.grocery.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAspectJAutoProxy
@ComponentScan("com.qp")
@EntityScan({"com.qp.assessment.grocery.booking.entities"})
@EnableAsync
public class GroceryBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryBookingApplication.class, args);
	}

}
