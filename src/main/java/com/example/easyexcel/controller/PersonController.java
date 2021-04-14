package com.example.easyexcel.controller;

import com.example.easyexcel.pojo.Person;
import com.example.easyexcel.pojo.PersonDTO;
import com.example.easyexcel.service.PersonService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;


import java.util.List;

@RequestMapping("/person")
@RestController
@Log
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Person> getAll() {
        return personService.queryAll();
    }

    @RequestMapping(value = "/getAllPerson", method = RequestMethod.GET)
    public List<Person> getAllPerson() {
        return personService.queryAll();
    }

    @PostMapping(value = "checkPerson")
    public Person checkPerson(@RequestBody @Validated PersonDTO person) {
        log.info(JSON.toJSONString(person));
        return person.getBody();
    }

    @PostMapping(value = "checkPerson2")
    public Person checkPerson2() {
        Person person = new Person();
        log.info(JSON.toJSONString(person));
        return person;
    }
}
