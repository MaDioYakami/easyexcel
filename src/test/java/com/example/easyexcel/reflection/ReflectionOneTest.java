package com.example.easyexcel.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectionOneTest {

    /**
     * 获取class对象的三种方式
     */
    @Test
    public void test1() {
        ReflectionOne reflectionOne = new ReflectionOne();
        reflectionOne.setName("name");
        reflectionOne.setAge("11");
        System.out.println(reflectionOne.toString());
        Class<? extends ReflectionOne> clazz = reflectionOne.getClass();
        //获取Person 类的所有方法信息
        Method[] method = clazz.getDeclaredMethods();
        for (Method m : method) {
            System.out.println(m.toString());
        }
        //获取Person 类的所有成员属性信息
        Field[] field = clazz.getDeclaredFields();
        for (Field f : field) {
            System.out.println(f.toString());
        }
        //获取Person 类的所有构造方法信息
        Constructor[] constructor = clazz.getDeclaredConstructors();
        for (Constructor c : constructor) {
            System.out.println(c.toString());
        }

    }

    /**
     * 获取对象的两种方式之一：
     * 使用Class 对象的newInstance()方法来创建该Class 对象对应类的实例，但是这种方法要求
     * 该Class 对象对应的类有默认的空构造器。
     * 调用Constructor 对象的 newInstance()
     */
    @Test
    public void test2() {
        try {
            //ReflectionOne类的Class对象
            Class clazz = Class.forName("com.example.easyexcel.reflection.ReflectionOne");
            //使用.newInstane 方法创建对象
            ReflectionOne p = (ReflectionOne) clazz.newInstance();
            System.out.println(p.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象的两种方式之一：
     * 先使用Class 对象获取指定的Constructor 对象，再调用Constructor 对象的newInstance()
     * 方法来创建 Class 对象对应类的实例,通过这种方法可以选定构造方法创建实例。
     */
    @Test
    public void test3() {

        try {
            //ReflectionOne类的Class对象
            Class clazz = Class.forName("com.example.easyexcel.reflection.ReflectionOne");
            //获取构造方法并创建对象
            Constructor c = clazz.getDeclaredConstructor(String.class, String.class);
            ReflectionOne p = (ReflectionOne) c.newInstance("张三", "123");
            System.out.println(p.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
