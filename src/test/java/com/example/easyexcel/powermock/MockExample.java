package com.example.easyexcel.powermock;

import com.example.easyexcel.pojo.Person;
import com.example.easyexcel.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.MockUtil;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class) // 告诉JUnit使用PowerMockRunner进行测试
@PrepareForTest({MockUtil.class}) // 所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
@PowerMockIgnore("javax.management.*") //为了解决使用powermock后，提示classloader错误
public class MockExample {

    @Mock
    private PersonService personService;

    /**
     * mock普通方法
     */
    @Test
    public void testSelectAppAdvertisementList() {
        Person person = new Person();
        person.setId("123");
        person.setName("name123");
        person.setAge(12);
        List<Person> list = new ArrayList<>();
        list.add(person);
        PowerMockito.when(personService.queryAll()).thenReturn(null).thenReturn(list);
        List<Person> people = personService.queryAll();
        if (people == null) {
            System.out.println("haha");
        }
        List<Person> people2 = personService.queryAll();
        if (people2 != null) {
            System.out.println(people2.toString());
        }
    }
}