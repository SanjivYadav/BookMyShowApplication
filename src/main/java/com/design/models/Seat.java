package com.design.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{

    private int seat_no;

    @Enumerated(EnumType.STRING)
    private SeatType type;
}
