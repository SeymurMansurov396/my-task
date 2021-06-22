package com.seymur.vabisstask.service;

import com.seymur.vabisstask.dto.request.SignUpRequestDTO;
import com.seymur.vabisstask.dto.response.ApiResponse;

public interface UserService {
    ApiResponse signUp(SignUpRequestDTO signUpRequestDTO);
}
