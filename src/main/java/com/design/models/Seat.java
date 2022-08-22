package com.design.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{

    private String seat_no;

    @Enumerated(EnumType.STRING)
    private SeatType type;
}
