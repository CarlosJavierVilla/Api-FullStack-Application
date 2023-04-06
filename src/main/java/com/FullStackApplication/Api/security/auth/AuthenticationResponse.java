package com.FullStackApplication.Api.security.auth;

import com.FullStackApplication.Api.security.user.Role;
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
  private String name;
  private Role role;
  private String email;
}
