package org.yoon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yoon.domain.Student;
import org.yoon.domain.StudentReqAdd;
import org.yoon.domain.StudentReqUpdate;
import org.yoon.mapper.StudentMapper;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentService {

    final StudentMapper studentMapper;

    public int add(StudentReqAdd request) {
        return studentMapper.addStudent(request.toEntity());
        // insert into Student value ( .. )
    }

    public ArrayList<Student> findAll() {
        return studentMapper.findAll();
        // select * from Student ;
    }

    public Student findById(long id) {
        return studentMapper.findById(id);
    }

    public int delete(long id) {
        int deleteCnt = studentMapper.deleteById(id);
        return deleteCnt;
        // delete   from Student  where id = .. ;
    }

    @Transactional
    public int update(long id, StudentReqUpdate request) {
        Student stu = studentMapper.findById(id);
        stu.setGrade(request.getGrade());
        stu.setName(request.getName());

        int updateCnt = studentMapper.updateStudent(stu);
        return updateCnt;
    }
}