package org.yoon.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.yoon.domain.Trip;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TripMapper2 {
    List<Trip> findAll();
    ArrayList<Trip> findByOrigin(String origin);
    int addTrip(Trip trip );
    int deleteTrip(int id);
    int updateTrip(Trip trip );
}
