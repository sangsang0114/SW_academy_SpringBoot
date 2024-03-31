package org.yoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trip {
    private int id;
    private String origin;
    private String destination;

    public Trip(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }
}
