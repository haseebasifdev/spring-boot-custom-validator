package com.codes.haseeb.customvalidators.controller;


import com.codes.haseeb.customvalidators.model.UserRegisterRequest;
import com.codes.haseeb.customvalidators.validator.user.register.UserRegisterRequestValidator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class UserRegisterController
{
  private UserRegisterRequestValidator userRegisterRequestValidator;

  @InitBinder("userRegisterRequest")
  protected void initBinderForUserRegisterRequest(WebDataBinder binder)
  {
    binder.addValidators(userRegisterRequestValidator);
  }

  @Validated
  @PostMapping("/register")
  public ResponseEntity<Object> register(@Valid @RequestBody UserRegisterRequest userRegisterRequest)
  {
    return ResponseEntity.ok(userRegisterRequest.toString());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
          MethodArgumentNotValidException ex)
  {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
}
