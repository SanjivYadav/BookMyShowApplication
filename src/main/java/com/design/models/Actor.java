package com.design.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @ManyToMany(mappedBy = "actors", fetch = FetchType.EAGER)
    private List<Movie> movieList;

    public void addMovie(Movie movie){
        movieList.add(movie);
    }

}
