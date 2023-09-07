package com.ballys.movierental.movie;

import lombok.Data;

@Data
public class MovieCriteria {

    private Integer page;
    private String title;
    private Integer year;
    private String genre;

}
