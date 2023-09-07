package com.ballys.movierental.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {

    private final MovieMapper movieMapper;

    @Transactional(readOnly = true)
    public Collection<Movie> findMoviesByCriteria(MovieCriteria movieCriteria) {
        return movieMapper.selectByCriteria(movieCriteria);
    }

}
