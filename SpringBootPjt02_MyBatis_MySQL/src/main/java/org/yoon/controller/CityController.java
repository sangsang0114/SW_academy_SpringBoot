package org.yoon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoon.domain.City;
import org.yoon.mapper.CityMapper;

import java.util.ArrayList;

@RestController
public class CityController {
    @Autowired
    CityMapper cityMapper;

    @GetMapping("/city")
    ArrayList<City> findAll() {
        return cityMapper.findAll();
    }

}
