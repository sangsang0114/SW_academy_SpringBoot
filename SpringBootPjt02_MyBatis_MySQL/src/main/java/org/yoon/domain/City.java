package org.yoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class City {
    private int id;
    private String cityName;
    private String country;

    public City(String cityName, String country) {
        this.cityName = cityName;
        this.country = country;
    }
}
