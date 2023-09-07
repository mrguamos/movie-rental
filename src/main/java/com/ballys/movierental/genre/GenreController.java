package com.ballys.movierental.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreMapper genreMapper;

    @GetMapping
    public Collection<Genre> findGenres() {
        return genreMapper.selectAll();
    }

}
