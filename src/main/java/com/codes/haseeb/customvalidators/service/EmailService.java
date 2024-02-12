package com.codes.haseeb.customvalidators.service;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
  public boolean isEmailAlreadyTaken(String username)
  {
    if (StringUtils.isBlank(username))
    {
      return true;
    }
    return username.contains("haseeb") || username.contains("asif");
  }
}
