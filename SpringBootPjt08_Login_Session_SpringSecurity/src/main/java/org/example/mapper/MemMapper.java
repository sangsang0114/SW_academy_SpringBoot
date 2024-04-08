package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Mem;

@Mapper
public interface MemMapper {
    @Select("select * from Mem where mem_id =#{mem_id} ")
    Mem findById(String id);

}
