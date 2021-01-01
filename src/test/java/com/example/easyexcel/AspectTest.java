package com.example.easyexcel;


import com.example.easyexcel.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AspectTest {

    @Autowired
    private Person person;
    @Test
    public void testOne() {
        person.setAge("11");

    }
}
