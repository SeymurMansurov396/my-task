package com.seymur.vabisstask.controller;

import com.seymur.vabisstask.dto.request.AuthorizeRequestDTO;
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
@RequestMapping("/api/authorize")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> authorize(@Valid @RequestBody AuthorizeRequestDTO authorizeRequestDTO) {
        ApiResponse apiResponse = userService.authorize(authorizeRequestDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
