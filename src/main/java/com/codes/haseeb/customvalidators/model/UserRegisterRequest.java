package com.codes.haseeb.customvalidators.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest
{
  @NotNull(message = "username cannot be null")
  @NotEmpty(message = "username cannot be blank")
  private String username;

  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private String gender;
  private String country;
  private String address;
  private String phoneNumber;
}