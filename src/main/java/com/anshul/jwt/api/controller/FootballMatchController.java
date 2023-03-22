package com.anshul.jwt.api.controller;

import com.anshul.jwt.api.service.FootballDrawsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballMatchController {

  @Autowired
  private FootballDrawsService footballDrawsService;

  @GetMapping("/matches/draws/{year}")
  @PreAuthorize("hasRole('ADMIN')")
  public int getDrawMatchesForYear(@PathVariable("year") int year) {
    return footballDrawsService.calculateDraws(year);
  }

}
