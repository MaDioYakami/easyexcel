package com.example.easyexcel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author madio
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NotNull(message = "id不能为空")
    private String id;
    @NotBlank(message = "name不能为空")
    private String name;
    @Min(10)
    private int age;


}
