package com.sprint.be_java_hisp_w21_g04.dto.validate;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ErrorDTO {

    String explanation;
    List<String> messages;

}
