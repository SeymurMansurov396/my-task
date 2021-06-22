package com.seymur.vabisstask.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthorizeRequestDTO {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
