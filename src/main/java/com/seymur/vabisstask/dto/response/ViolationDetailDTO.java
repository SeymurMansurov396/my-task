package com.seymur.vabisstask.dto.response;

import lombok.Data;

@Data
public class ViolationDetailDTO {
    private String rejectedField;
    private Object rejectedValue;
}
