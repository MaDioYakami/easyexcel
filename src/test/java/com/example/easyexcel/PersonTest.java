package com.example.easyexcel;


import com.example.easyexcel.pojo.Person;
import com.example.easyexcel.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonTest {

    @Autowired
    PersonService personService;


    @Test
    public void TestOne() {
        List<Person> personList = personService.queryAll();
        //personList.forEach(System.out::println);
        personList.forEach((el)->{System.out.println(el.toString());});

    }

}
