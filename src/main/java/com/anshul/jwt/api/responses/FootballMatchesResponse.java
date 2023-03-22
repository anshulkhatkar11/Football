package com.anshul.jwt.api.responses;

import com.anshul.jwt.api.entity.FootballMatch;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FootballMatchesResponse {
  private int totalPages;
  private List<FootballMatch> data;
}
