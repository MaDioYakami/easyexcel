package com.example.easyexcel.mapper;

import com.example.easyexcel.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author madio
 */

@Repository
public interface PersonMapper {
    //@Select("select * from person")
    List<Person> queryAll();
}
