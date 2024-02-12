package com.codes.haseeb.customvalidators.validator.user.register;

import com.codes.haseeb.customvalidators.model.UserRegisterRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Map;
import java.util.TreeMap;

@Component
@RequiredArgsConstructor
public class UserRegisterRequestValidator implements Validator
{
  private final ApplicationContext applicationContext;
  private TreeMap<Object, Object> sortedValidators;

  @Override
  public boolean supports(Class<?> clazz)
  {
    return UserRegisterRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors)
  {
    UserRegisterRequest userRegisterRequest = (UserRegisterRequest) target;
    for (Object bean : sortedValidators.values())
    {
      if (!(bean instanceof IUserRegisterRequestValidation))
      {
        continue;
      }
      if (!((IUserRegisterRequestValidation) bean).validate(userRegisterRequest, errors))
      {
        return;
      }
    }
  }

  @PostConstruct
  public void init()
  {
    Map<String, Object> userRegisterValidators = applicationContext.getBeansWithAnnotation(UserRegisterValidationRegistration.class);
    sortedValidators = new TreeMap<>();
    for (Map.Entry<String, Object> entry : userRegisterValidators.entrySet())
    {
      int order = entry.getValue().getClass().getAnnotation(UserRegisterValidationRegistration.class).order();
      sortedValidators.put(order, entry.getValue());
    }
  }
}
