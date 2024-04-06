package org.yoon.domain;

import lombok.Getter;

@Getter
public class StudentResponse {
    private final String name;
    private final int grade;
    private final int id;

    public StudentResponse(Student student) {
        this.name = student.getName();
        this.grade = student.getGrade();
        this.id = student.getId();
    }
}

