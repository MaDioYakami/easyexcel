package com.example.easyexcel.service.impl;

import com.example.easyexcel.mapper.PersonMapper;
import com.example.easyexcel.pojo.Person;
import com.example.easyexcel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author madio
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> queryAll() {
        return personMapper.queryAll();
    }
}
