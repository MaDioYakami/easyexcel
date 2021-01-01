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

    /**
     * Around方法环绕start.....
     * Before进入方法前执行.....
     * AfterReturning方法的返回值 : madio
     * After方法最后执行.....
     * Around方法环绕proceed，结果是 :madio
     */
    @Autowired
    private Person person;

    @Test
    public void testOne() {
        person.setName("madio");
        person.setAge(11);
        person.toString();
        person.getName();

    }
}
