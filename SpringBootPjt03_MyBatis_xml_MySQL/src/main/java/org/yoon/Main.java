package org.yoon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yoon.domain.Trip;
import org.yoon.mappers.TripMapper2;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final TripMapper2 tripMapper;

    public Main(TripMapper2 tripMapper) {
        this.tripMapper = tripMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.tripMapper.findByOrigin("ATL"));
        System.out.println(this.tripMapper.findAll());

        System.out.println(this.tripMapper.addTrip(new Trip("BKK", "ICN")));
        System.out.println(this.tripMapper.deleteTrip(1));
        System.out.println(this.tripMapper.updateTrip(new Trip(2, "BKK", "ICN")));
    }
}