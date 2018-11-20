package com.netcracker.edu.backend.validator;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "login", "Required" );
        if(user.getLogin().length() < 8  || user.getLogin().length() > 32){
            errors.rejectValue("login","Size.userForm.login");
        }

        if(userService.findByLogin(user.getLogin()) != null){
            errors.rejectValue("login","Duplicate.userForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if(user.getPassword().length() < 8  || user.getPassword().length() > 32){
            errors.rejectValue("password","Size.userForm.password");
        }
    }
}
