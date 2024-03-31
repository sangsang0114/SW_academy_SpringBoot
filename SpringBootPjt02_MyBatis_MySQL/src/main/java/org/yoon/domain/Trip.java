package org.yoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trip {
    private int id;
    private String destination;
    private String origin;

    public Trip(String destination, String origin) {
        this.destination = destination;
        this.origin = origin;
    }
}
