package com.keimiokamoto.weatherservice.data;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.awt.geom.Point2D;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WeatherRepositoryTest {

  @InjectMocks
  private static WeatherRepository weatherRepository;

  @Test
  public void shouldGetStationLocationToWeatherMap() {
    Map<Point2D.Double, String> stationLocationToWeatherMap = weatherRepository
        .getStationLocationToWeatherMap();
    assertFalse(stationLocationToWeatherMap.isEmpty());
  }

  @Test
  public void shouldGetCityLocationToCityNameMap() {
    Map<Point2D.Double, String> cityLocationToCityNameMap = weatherRepository
        .getCityLocationToCityNameMap();
    assertFalse(cityLocationToCityNameMap.isEmpty());
  }
}