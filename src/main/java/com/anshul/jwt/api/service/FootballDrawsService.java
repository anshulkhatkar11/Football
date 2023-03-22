package com.anshul.jwt.api.service;

import com.anshul.jwt.api.entity.FootballMatch;
import com.anshul.jwt.api.responses.FootballMatchesResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FootballDrawsService {
  public int calculateDraws(int year){
    RestTemplate restTemplate = new RestTemplate();
    int totalDraws = 0;
    int totalPages = 1;
    int page = 1;

    while (page <= totalPages) {
      String url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=" + page;
      FootballMatchesResponse response = restTemplate.getForObject(url, FootballMatchesResponse.class);

      if (response == null) {
        return 0;
      }

      totalPages = response.getTotalPages();

      for (FootballMatch match : response.getData()) {
        if (match.getHomeGoals() == match.getAwayGoals()) {
          totalDraws++;
        }
      }

      page++;
    }

    return totalDraws;
  }

}
