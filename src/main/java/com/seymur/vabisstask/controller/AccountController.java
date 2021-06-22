package com.seymur.vabisstask.controller;

import com.seymur.vabisstask.dto.request.SignUpRequestDTO;
import com.seymur.vabisstask.dto.response.ApiResponse;
import com.seymur.vabisstask.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO) {
        ApiResponse apiResponse = userService.signUp(signUpRequestDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
