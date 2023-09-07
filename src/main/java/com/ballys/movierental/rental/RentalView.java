package com.ballys.movierental.rental;

import com.ballys.movierental.movie.Movie;
import com.ballys.movierental.user.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalView {

    private Long id;
    private User user;
    private Movie movie;
    private LocalDate rentDate;
    private LocalDate dueDate;

}
