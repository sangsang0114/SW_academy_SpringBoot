package org.yoon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoon.domain.Trip;
import org.yoon.mapper.TripMapper;

import java.util.ArrayList;

@RestController
public class TripController {
    @Autowired
    TripMapper tripMapper;

    @GetMapping("/trip")
    ArrayList<Trip> findAll() {
        return tripMapper.findAll();
    }

}
