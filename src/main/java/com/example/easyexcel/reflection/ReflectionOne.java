package com.example.easyexcel.reflection;

import lombok.Data;

/**
 * @author madio
 */
@Data
public class ReflectionOne {
    private String name;
    private String age;

    public ReflectionOne() {
    }

    public ReflectionOne(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
