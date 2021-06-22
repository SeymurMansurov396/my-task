package com.seymur.vabisstask.service;

import com.seymur.vabisstask.dto.request.SignUpRequestDTO;
import com.seymur.vabisstask.dto.response.ApiResponse;
import com.seymur.vabisstask.model.User;


public interface UserService {
    ApiResponse signUp(SignUpRequestDTO signUpRequestDTO);


    ApiResponse aboutMe();
}
