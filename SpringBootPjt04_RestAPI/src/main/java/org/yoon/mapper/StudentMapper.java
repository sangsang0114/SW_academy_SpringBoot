package org.yoon.mapper;

import org.apache.ibatis.annotations.*;
import org.yoon.domain.Student;

import java.util.ArrayList;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    ArrayList<Student> findAll();

    @Select("select * from student where id = #{id}")
    Student findById(long id);

    @Insert("insert into student (name, grade) values (#{name},#{grade})")
    int addStudent(Student student);

    @Update("Update student set name=#{name}, grade=#{grade} where id=#{id} ")
    int updateStudent(Student student);

    @Delete("delete from student where id=#{id}")
    int deleteById(long id);
}
