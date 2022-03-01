package com.keimiokamoto.weatherservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.keimiokamoto.weatherservice.data.WeatherRepository;
import java.awt.geom.Point2D;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

  @InjectMocks
  private WeatherService weatherService;

  @Mock
  private WeatherRepository weatherRepository;

  @Test
  public void shouldGetLocationToWeatherMap() {
    when(weatherRepository.getStationLocationToWeatherMap()).thenReturn(stationLocationToWeather());
    when(weatherRepository.getCityLocationToCityNameMap()).thenReturn(CityLocationToCityName());
    Map<String, String> actualLocationToWeatherMap = weatherService.getLocationToWeatherMap();
    assertEquals(expectedLocationToWeatherMap(), actualLocationToWeatherMap);
  }

  private Map<String, String> expectedLocationToWeatherMap() {
    return Map.of("London", "Cold", "Glasgow", "Cold");
  }

  private static Map<Point2D.Double, String> CityLocationToCityName() {
    return Map.of(
        new Point2D.Double(-4.095055, 55.852059), "Glasgow",
        new Point2D.Double(-0.002505, 51.503892), "London"
    );
  }

  private static Map<Point2D.Double, String> stationLocationToWeather() {
    return Map.of(
        new Point2D.Double(-111.689978, 33.517941), "Sunny", // Arizona US
        new Point2D.Double(-155.100255, 19.336835), "Stormy", // Hawaii
        new Point2D.Double(-6.519751, 53.282845), "Cold" // Dublin
    );
  }
}
