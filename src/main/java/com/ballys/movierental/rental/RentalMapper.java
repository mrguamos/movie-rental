package com.ballys.movierental.rental;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface RentalMapper {

    Collection<RentalView> selectByUserId(@Param("userId") Long userId);
    void insert(@Param("entity") Rental rental);

}
