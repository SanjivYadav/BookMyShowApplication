package com.design.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{

    /*
     * 1 : 1
     * M: 1
     * */
    @ManyToOne
    private Show show;

    /*
     * 1 : 1
     * M: 1
     * */
    @ManyToOne
    private Seat seat;

    private ShowSeatStatus ShowSeatStatus;
}
