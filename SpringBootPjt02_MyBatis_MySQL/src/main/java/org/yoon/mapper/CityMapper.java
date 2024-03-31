package org.yoon.mapper;

import org.apache.ibatis.annotations.*;
import org.yoon.domain.City;

import java.util.ArrayList;

@Mapper
public interface CityMapper {

    @Select("SELECT * FROM CITY")
    ArrayList<City> findAll();

    @Select("SELECT * FROM CITY WHERE id = #{id}")
    City findById(@Param("id") int id);

    @Select("SELECT * FROM CITY WHERE country = #{country}")
    ArrayList<City> findByCountry(String country);

    @Insert("INSERT INTO CITY (cityname, country) values (#{cityName}, #{country})")
    int addCity(City c);

    @Update("UPDATE CITY SET cityname=#{cityName}, country=#{country} where id=#{id}")
    int updateCity(City c);

    @Delete("DELETE FROM CITY WHERE id=#{id}")
    int delete(int id);
}
