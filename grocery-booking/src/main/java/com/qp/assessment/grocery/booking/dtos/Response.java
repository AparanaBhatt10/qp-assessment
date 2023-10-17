package com.qp.assessment.grocery.booking.dtos;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;


@Data
public class Response <T>{

    private int status;
    private String message;
    private List<T> listData;
    private Integer count;
    private Integer pageNo;
    private Integer totalPages;
    private Long totalElements;
    private Boolean last;
    private T data;
    private Date date;



    public Response(int status,T data){
        this.status=status;
        this.data=data;
    }


    public Response(Page<T> data) {
        this.listData = data.getContent();
        this.last = data.isLast();
        this.totalPages = data.getTotalPages();
        this.pageNo = data.getNumber();
        this.totalElements=data.getTotalElements();


    }

    public Response(Date date, int value, String message) {

        this.date=date;
        this.status=value;
        this.message=message;

    }
}
