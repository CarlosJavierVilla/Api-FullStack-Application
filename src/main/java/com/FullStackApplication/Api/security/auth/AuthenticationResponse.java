package com.FullStackApplication.Api.security.auth;

import com.factoriaf5.auth6.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  private String firstName;
  private Role role;
  private String email;
}
