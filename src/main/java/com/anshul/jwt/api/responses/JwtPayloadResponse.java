package com.anshul.jwt.api.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class JwtPayloadResponse {
  private String username;
  private Instant expiration;
}
