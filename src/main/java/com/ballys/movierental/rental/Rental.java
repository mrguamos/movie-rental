package com.ballys.movierental.rental;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Builder
@Value
public class Rental {

    Long userId;
    Long movieId;
    LocalDate rentDate;
    LocalDate dueDate;
}
