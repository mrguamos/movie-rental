package com.ballys.movierental.rental;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RentalInput {

    @NotNull
    private Long movieId;
    @NotNull
    private Long userId;

}
