package org.yoon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int grade;

    @Builder
    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

}