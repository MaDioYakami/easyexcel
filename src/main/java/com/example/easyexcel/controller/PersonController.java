package com.example.easyexcel.controller;

import com.example.easyexcel.pojo.Person;
import com.example.easyexcel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/person")
@RestController
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
}
