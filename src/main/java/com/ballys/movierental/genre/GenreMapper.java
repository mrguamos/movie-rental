package com.ballys.movierental.genre;

import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface GenreMapper {

    Collection<Genre> selectAll();

}
