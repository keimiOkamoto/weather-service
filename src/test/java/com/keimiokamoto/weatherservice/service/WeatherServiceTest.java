package com.keimiokamoto.weatherservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

  @InjectMocks
  private WeatherService weatherService;

  @Test
  public void shouldGetLocationToWeatherMap() {
  }
}
