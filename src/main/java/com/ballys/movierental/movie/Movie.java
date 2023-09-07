package com.ballys.movierental.movie;

import com.ballys.movierental.genre.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {

    private Long id;
    private String title;
    private BigDecimal price;
    private Integer year;
    private Integer quantity;
    private Collection<Genre> genre;
}
