package com.design.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String refrence_id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private Date time;

    /*
    * 1 : 1
    * M : 1
    * */
    @ManyToOne
    private Ticket ticket;
}
