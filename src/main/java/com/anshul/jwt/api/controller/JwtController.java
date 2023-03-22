package com.anshul.jwt.api.controller;

import com.anshul.jwt.api.requests.JwtTokenRequest;
import com.anshul.jwt.api.responses.JwtPayloadResponse;
import com.anshul.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/jwt")
  public JwtPayloadResponse getJwtValues(@RequestBody JwtTokenRequest token) {

    JwtPayloadResponse response=new JwtPayloadResponse();
    response.setExpiration(jwtUtil.extractExpiration(token.getToken()).toInstant());
    response.setUsername(jwtUtil.extractUsername(token.getToken()));
    return response;
  }

}


