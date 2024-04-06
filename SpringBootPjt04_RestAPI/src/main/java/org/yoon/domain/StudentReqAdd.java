package org.yoon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentReqAdd {
    private String name;
    private int grade;

    public Student toEntity() {
        return Student.builder()
                .name(name)
                .grade(grade)
                .build();  // new Student(name, grade )
    }
}