package com.seymur.vabisstask.util.annotation;

import com.seymur.vabisstask.util.annotation.validator.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public  @interface UniqueUsername {
    String message() default "Username is not unique and already exists in DB";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
