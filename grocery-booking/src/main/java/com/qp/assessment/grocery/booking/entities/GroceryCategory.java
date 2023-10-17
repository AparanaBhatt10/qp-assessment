package com.qp.assessment.grocery.booking.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "grocery_category")
@Data
public class GroceryCategory extends AbstractEntity{


    @Column(name = "name")
    private String name;

    @Column(name = "des")
    private String description;
}
