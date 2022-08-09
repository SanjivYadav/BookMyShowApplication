package com.design.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
@Entity
@Getter
@Setter
public class Actor extends BaseModel{
    private String name;
    /*
     * 1 : M
     * M : 1
     * */
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movieList;

}
