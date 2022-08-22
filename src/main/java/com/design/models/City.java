package com.design.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    private String name;
    /**
     * 1 : M
     * 1  :  1
     */
    @OneToMany(fetch = FetchType.EAGER)
    private List<Theater> theathers;

    public void addTheater(Theater theater){
        theathers.add(theater);
    }
}
