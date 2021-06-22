package com.seymur.vabisstask.dto.request;

import com.seymur.vabisstask.util.annotation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SignUpRequestDTO {

    @NotEmpty
    @UniqueUsername
    private String username;
    @NotEmpty
    private String password;
}
