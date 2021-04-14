package com.example.easyexcel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Header {
    @NotNull(message = "topic不能为空")
    private String topic;


}
