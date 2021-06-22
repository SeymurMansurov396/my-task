package com.seymur.vabisstask.service.impl;

import com.seymur.vabisstask.dto.request.SignUpRequestDTO;
import com.seymur.vabisstask.dto.response.ApiResponse;
import com.seymur.vabisstask.model.User;
import com.seymur.vabisstask.repository.UserRepository;
import com.seymur.vabisstask.service.UserService;
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

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ApiResponse signUp(SignUpRequestDTO signUpRequestDTO) {
        User user = new User();
        user.setUsername(signUpRequestDTO.getUsername());
        user.setPassword(signUpRequestDTO.getPassword());
        user.setIsEnabled(1);
        userRepository.save(user);
        boolean success = false;
        if (user.getId() > 0) {
            success = true;
        }
        return new ApiResponse(success);
    }
}
