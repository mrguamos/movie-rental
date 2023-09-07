package com.ballys.movierental.movie;

import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    @GetMapping
    public Collection<Movie> findMoviesByCriteria(@ParameterObject MovieCriteria criteria) {
        return movieService.findMoviesByCriteria(criteria);
    }

}
