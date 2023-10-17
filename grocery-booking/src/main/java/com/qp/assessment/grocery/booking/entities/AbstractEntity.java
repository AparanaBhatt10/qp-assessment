package com.qp.assessment.grocery.booking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 5646557584769485464L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    protected Long id;
    @Column(
            name = "created_date",
            updatable = false
    )
    protected Long createdDate;
    @Column(
            name = "status"
    )
    protected Boolean status;
    @Column(
            name = "created_by"
    )
    protected Long createdBy;
    @Column(
            name = "updated_date"
    )
    protected Long updatedDate;


    public void setCreatedDate() {
        this.createdDate = System.currentTimeMillis();
    }

    public void setCreatedDate(long timeStamp) {
        this.createdDate = timeStamp;
    }

    public void setUpdatedDate() {
        this.updatedDate = System.currentTimeMillis();
    }

    public void createdBy(Long createdBy) {
        this.createdBy = createdBy;
    }


    @PreUpdate
    protected void preUpdate() {
        this.updatedDate = System.currentTimeMillis();
    }

    @PrePersist
    protected void prePersist() {
        this.createdDate = System.currentTimeMillis();
    }


}