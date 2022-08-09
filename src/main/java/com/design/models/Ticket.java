package com.design.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{

    private long ticketNo;

    /*
     * 1 : 1
     * M : 1
     * */
    @ManyToOne
    private Show show;

    /*
     * 1 : M
     * M : 1
     * */
    @ManyToMany
    private List<ShowSeat> bookedSeats;

    /*
     * 1 : 1
     * M : 1
     * */
    @ManyToOne
    private Auditorium auditorium;

    /*
     * 1 : 1
     * M : 1
     * */
    @ManyToOne
    private User bookedBy;

    /*
     * 1 : M
     * 1 : 1
     * */
    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

    private Date bookingTime;

    private double amount;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    public Ticket() {
    }
}
