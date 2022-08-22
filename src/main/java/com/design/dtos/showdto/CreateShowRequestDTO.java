package com.design.dtos.showdto;

import com.design.models.Language;
import com.design.models.MovieFeature;
import com.design.models.SeatType;
import com.design.models.ShowFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CreateShowRequestDTO {
    private Long movie_Id;
    private Long auditorium_Id;
    private Date start_time;
    private Date end_time;
    private List<ShowFeature> showFeatures;
    private Map<SeatType, Double> showSeatTypePrice;
}
