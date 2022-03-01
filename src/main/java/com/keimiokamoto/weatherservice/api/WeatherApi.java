package com.keimiokamoto.weatherservice.api;


import com.keimiokamoto.weatherservice.data.WeatherResponse;
import com.keimiokamoto.weatherservice.service.WeatherService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApi {

  private final WeatherService weatherService;

  public WeatherApi(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping("/v1/weather")
  public List<WeatherResponse> getAllWeather() {
    return weatherService.getLocationToWeatherMap().entrySet().stream()
        .map(e -> new WeatherResponse(e.getKey(), e.getValue())).collect(
            Collectors.toList());
  }
}
