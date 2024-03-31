package org.yoon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yoon.domain.Trip;
import org.yoon.mappers.TripMapper2;

import java.util.List;

@RestController
public class TripController {
    @Autowired
    TripMapper2 tripMapper;


    // http://localhost:8080/trips
    @GetMapping("/trips")
    List<Trip> findAll(){
        return tripMapper.findAll();
    }


    // http://localhost:8080/trip?origin=BKK
    @GetMapping("/trip")
    List<Trip>findByOrigin(@RequestParam String origin){
        System.out.println(origin);
        return tripMapper.findByOrigin(origin);
    }


    // http://localhost:8080/trip/1111
    @GetMapping("/trip/{id}")
    String test(@PathVariable long id){
        System.out.println(id);
        return id+"" ;
    }

    // http://localhost:8080/trip
    @PostMapping("/trip")
    int add(@RequestBody Trip trip){
        return  tripMapper.addTrip(trip) ;
    }

}