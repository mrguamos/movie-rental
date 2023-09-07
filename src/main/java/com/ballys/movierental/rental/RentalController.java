package com.ballys.movierental.rental;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @GetMapping
    public Collection<RentalView> findRentalsByUserId(@RequestParam(required = false) Long userId) {
        return rentalService.findRentalsByUserId(userId);
    }

    @PostMapping
    public void rent(@RequestBody @Valid RentalInput input) {
        LocalDate rentDate = LocalDate.now();
        rentalService.saveRental(
                Rental.builder()
                        .movieId(input.getMovieId())
                        .userId(input.getUserId())
                        .rentDate(rentDate)
                        .dueDate(rentDate.plus(10, ChronoUnit.DAYS))
                        .build()
        );
    }

}
