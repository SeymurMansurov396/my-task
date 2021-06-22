package com.seymur.vabisstask.service.impl;

import com.seymur.vabisstask.config.security.JwtTokenUtil;
import com.seymur.vabisstask.dto.request.AuthorizeRequestDTO;
import com.seymur.vabisstask.dto.request.SignUpRequestDTO;
import com.seymur.vabisstask.dto.response.ApiResponse;
import com.seymur.vabisstask.dto.response.AuthorizeResponseDTO;
import com.seymur.vabisstask.exception.custom.UserAlreadyExistsException;
import com.seymur.vabisstask.exception.custom.WrongPasswordException;
import com.seymur.vabisstask.exception.custom.WrongUserNameException;
import com.seymur.vabisstask.model.User;
import com.seymur.vabisstask.repository.UserRepository;
import com.seymur.vabisstask.service.UserService;
import com.seymur.vabisstask.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public ApiResponse signUp(SignUpRequestDTO signUpRequestDTO) {
        if (checkIfUserExists(signUpRequestDTO.getUsername())) {
            throw new UserAlreadyExistsException("user with username: " + signUpRequestDTO.getUsername() + " ,already exists");
        }
        User user = new User();
        user.setUsername(signUpRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequestDTO.getPassword()));
        user.setIsEnabled(1);
        userRepository.save(user);
        boolean success = false;
        if (user.getId() > 0) {
            success = true;
        }
        return new ApiResponse(success);
    }

    @Override
    public ApiResponse aboutMe() {
        String username = Utils.getUsername();
        User user = userRepository.findAllByUsernameAndIsEnabled(username, 1);
        String message = null;
        boolean success = false;
        if (user != null) {
            success = true;
            message = "Hello : " + username;
        }
        return new ApiResponse(success, message);
    }

    @Override
    public ApiResponse authorize(AuthorizeRequestDTO authorizeRequestDTO) {
        String username = authorizeRequestDTO.getUsername();
        String password = authorizeRequestDTO.getPassword();
        User user = userRepository.findAllByUsernameAndIsEnabled(username, 1);
        if (user == null) {
            throw new WrongUserNameException("Wrong username");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new WrongPasswordException("Wrong password");
        }

        String token = jwtTokenUtil.generateToken(username);
        AuthorizeResponseDTO authorizeResponseDTO = new AuthorizeResponseDTO();
        authorizeResponseDTO.setToken(token);
        return new ApiResponse(true, authorizeResponseDTO);
    }

    private boolean checkIfUserExists(String username) {
        if (userRepository.findAllByUsernameAndIsEnabled(username, 1) != null) {
            return true;
        }
        return false;
    }


}
