package com.codes.haseeb.customvalidators.service;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsernameService
{
  // Define the pattern
  String patternString = "[a-zA-Z0-9_-]{3,20}";

  // Compile the pattern
  Pattern pattern = Pattern.compile(patternString);

  public boolean isUsernameAlreadyTaken(String username)
  {
    if (StringUtils.isBlank(username))
    {
      return true;
    }
    return username.equalsIgnoreCase("haseeb") || username.equalsIgnoreCase("asif");
  }

  public boolean isPatternMatches(String username)
  {
    if (StringUtils.isBlank(username))
    {
      return false;
    }
    Matcher matcher = pattern.matcher(username);
    return matcher.matches();
  }
}
