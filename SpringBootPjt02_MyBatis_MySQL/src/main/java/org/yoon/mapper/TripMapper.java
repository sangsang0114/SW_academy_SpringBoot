package org.yoon.mapper;

import org.apache.ibatis.annotations.*;
import org.yoon.domain.Trip;

import java.util.ArrayList;

@Mapper
public interface TripMapper {

    @Select("SELECT * FROM Trip")
    ArrayList<Trip> findAll();
}
