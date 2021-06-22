package com.seymur.vabisstask.controller;

import com.seymur.vabisstask.dto.request.SignUpRequestDTO;
import com.seymur.vabisstask.dto.response.ApiResponse;
import com.seymur.vabisstask.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/me")
    public ResponseEntity<?> aboutMe() {
        ApiResponse apiResponse = userService.aboutMe();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
