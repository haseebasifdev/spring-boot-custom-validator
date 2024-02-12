package com.codes.haseeb.customvalidators.validator.user.register;

import com.codes.haseeb.customvalidators.model.UserRegisterRequest;
import org.springframework.validation.Errors;

@FunctionalInterface
public interface IUserRegisterRequestValidation
{
  boolean validate(UserRegisterRequest registerRequest, Errors errors);
}
