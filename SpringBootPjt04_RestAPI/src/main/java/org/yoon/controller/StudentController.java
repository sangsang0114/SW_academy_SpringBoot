package org.yoon.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yoon.domain.Student;
import org.yoon.domain.StudentReqAdd;
import org.yoon.domain.StudentReqUpdate;
import org.yoon.domain.StudentResponse;
import org.yoon.service.StudentService;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    ResponseEntity<List<StudentResponse>> findall(){
        List<StudentResponse> stulist = studentService.findAll().stream()
                .map(StudentResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(stulist);
    }

    @GetMapping("/students/{id}")
    ResponseEntity<StudentResponse> findById(@PathVariable long id){
        Student stu = studentService.findById(id);
        return ResponseEntity.ok()
                .body(new StudentResponse(stu));
    }


    @PostMapping("/students")
    public ResponseEntity add(@RequestBody StudentReqAdd request) {
        int addCnt = studentService.add(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addCnt);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        studentService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody StudentReqUpdate request) {
        int updateCnt = studentService.update(id,request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(updateCnt);
    }

}

