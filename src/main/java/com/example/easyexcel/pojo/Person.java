package com.example.easyexcel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author madio
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private String age;


}
