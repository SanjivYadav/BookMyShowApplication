package com.design.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Theater extends BaseModel{
    private String name;
    private String address;
    /*
    * 1 : M
    * 1 : 1
    */
    @OneToMany(mappedBy = "theater")
    private List<Auditorium> auditoriums;
    /*
    * 1 : M
    * 1 : 1
    */
    @OneToMany
    private List<Show> UpCommingShows;


}
