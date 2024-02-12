package com.codes.haseeb.customvalidators.validator.user.register;

import com.codes.haseeb.customvalidators.model.UserRegisterRequest;
import com.codes.haseeb.customvalidators.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@UserRegisterValidationRegistration(order = 2)
@Component
@AllArgsConstructor
public class UserRegisterEmailValidation implements IUserRegisterRequestValidation
{
  private static final String EMAIL_FIELD = "email";
  private static final String EMAIL_ALREADY_TAKEN = "email already taken";

  private final EmailService emailService;

  @Override
  public boolean validate(UserRegisterRequest registerRequest, Errors errors)
  {
    if (errors.hasErrors())
    {
      return false;
    }
    if (emailService.isEmailAlreadyTaken(registerRequest.getEmail()))
    {
      errors.rejectValue(EMAIL_FIELD, HttpStatus.BAD_REQUEST.name(), EMAIL_ALREADY_TAKEN);
      return false;
    }
    return true;
  }
}
