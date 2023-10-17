package com.qp.assessment.grocery.booking.entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="users")
@Data
public class User extends AbstractEntity {


    @Column(name = "mobile")
    private String mobile;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;


}
