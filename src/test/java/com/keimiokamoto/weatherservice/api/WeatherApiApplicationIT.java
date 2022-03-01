package com.keimiokamoto.weatherservice.api;


import static org.junit.jupiter.api.Assertions.assertFalse;

import com.keimiokamoto.weatherservice.WeatherServiceApplication;
import com.keimiokamoto.weatherservice.data.WeatherResponse;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = WeatherServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class WeatherApiApplicationIT {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void shouldGetWeatherForAllCities() {
    List<WeatherResponse> actualResponse = this.restTemplate
        .getForObject("http://localhost:" + port + "/v1/weather", List.class);
    assertFalse(expectedWeatherResponseList().isEmpty());
    CollectionUtils.isEqualCollection(actualResponse, expectedWeatherResponseList());
  }

  private List<WeatherResponse> expectedWeatherResponseList() {
    return Arrays.asList(
        new WeatherResponse("Glasgow", "Cold"),
        new WeatherResponse("London", "Chilly"),
        new WeatherResponse("Brussels", "Chilly"),
        new WeatherResponse("Tokyo", "Monsoon"),
        new WeatherResponse("Honolulu", "Stormy"),
        new WeatherResponse("Los-Angeles", "Sunny")
    );
  }
}
