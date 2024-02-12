package com.codes.haseeb.customvalidators.validator.user.register;

import com.codes.haseeb.customvalidators.model.UserRegisterRequest;
import com.codes.haseeb.customvalidators.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@UserRegisterValidationRegistration(order = 3)
@AllArgsConstructor
public class UserRegisterPasswordValidator implements IUserRegisterRequestValidation
{
  private static final String PASSWORD_FIELD = "email";
  private static final String PASSWORD_NOT_STRONG = "Password does not follow the Expected Pattern";
  private final PasswordService passwordService;

  @Override
  public boolean validate(UserRegisterRequest registerRequest, Errors errors)
  {
    if (errors.hasErrors())
    {
      return false;
    }
    if (!passwordService.isValidPattern(registerRequest.getPassword()))
    {
      errors.rejectValue(PASSWORD_FIELD, HttpStatus.BAD_REQUEST.name(), PASSWORD_NOT_STRONG);
      return false;
    }
    return true;
  }
}
