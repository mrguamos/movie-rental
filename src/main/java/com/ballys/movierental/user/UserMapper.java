package com.ballys.movierental.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface UserMapper {

    long insert(@Param("entity") User user);
    Collection<User> selectAll();

}
