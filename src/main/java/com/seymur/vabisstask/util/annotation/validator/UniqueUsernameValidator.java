package com.seymur.vabisstask.util.annotation.validator;

import com.seymur.vabisstask.exception.custom.UserAlreadyExistsException;
import com.seymur.vabisstask.model.User;
import com.seymur.vabisstask.repository.UserRepository;
import com.seymur.vabisstask.util.annotation.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        User user = userRepository.findAllByUsernameAndIsEnabled(s, 1);
        if (user == null) {
            return true;
        } else {
            throw new UserAlreadyExistsException();
        }


    }
}
