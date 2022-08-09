package com.design.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{
    private int anudi_no;
    /*
    * 1 : M
    * 1 : 1
    *
    */
    @OneToMany
    private List<Seat> seats;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;
    private int capacity;

    /*
     * 1 : 1
     * M : 1
     *
     */
    @ManyToOne
    private Theater theater;
}
