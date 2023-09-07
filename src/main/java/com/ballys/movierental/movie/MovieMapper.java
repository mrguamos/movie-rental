package com.ballys.movierental.movie;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface MovieMapper {

    Collection<Movie> selectByCriteria(@Param("criteria") MovieCriteria movieCriteria);
    Integer selectQuantity(@Param("id") Long id);
    void updateQuantity(@Param("id") Long id, @Param("quantity") Integer quantity);
    void exclusiveLock();
    void commitTransaction();

    void rollbackTransaction();
}
   