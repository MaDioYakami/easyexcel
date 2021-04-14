package com.example.easyexcel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
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
public class PersonDTO {
    @NotNull(message = "header不能为空")
    @Valid
    private Header header;
    @NotNull(message = "body不能为空")
    @Valid
    private Person body;

}
