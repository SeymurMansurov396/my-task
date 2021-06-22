package com.seymur.vabisstask.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SignUpRequestDTO {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
