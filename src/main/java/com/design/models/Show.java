package com.design.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{

    /*
    * 1 : 1
    * M : 1
    * */
    @ManyToOne
    private Movie movie;

    private Date start_time;

    private Date end_time;

    /*
     * 1 : 1
     * M : 1
     * */
    @ManyToOne
    private Auditorium auditorium;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ShowFeature> showFeatures;

    private Language language;

    /*
     * 1 : M
     * 1: 1
     * */
    @OneToMany(mappedBy = "show")
    private List<ShowSeatType> ShowSeatTypes;

    /*
     * 1 : M
     * 1: 1
     * */
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;
}
