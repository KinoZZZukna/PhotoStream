package com.photostream.validations;

import com.photostream.annotations.PasswordMatches;
import com.photostream.payload.request.SignupRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {}

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SignupRequest userSignupRequest = (SignupRequest) o;

        return userSignupRequest.getPassword().equals(userSignupRequest.getConfirmPassword());
    }
}
