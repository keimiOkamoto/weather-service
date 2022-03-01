package com.keimiokamoto.weatherservice.service;

import com.keimiokamoto.weatherservice.data.WeatherRepository;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

  private final WeatherRepository weatherRepository;

  public WeatherService(WeatherRepository weatherRepository) {
    this.weatherRepository = weatherRepository;
  }

  public Map<String, String> getLocationToWeatherMap() {
    return calculateNearestWeatherStationsForCity();
  }

  private Map<String, String> calculateNearestWeatherStationsForCity() {
    Map<String, String> locationToWeatherMap = new HashMap<>();
    for (Entry<Point2D.Double, String> entry1 : weatherRepository.getCityLocationToCityNameMap()
        .entrySet()) {
      double minDistance = Double.MAX_VALUE;
      for (Entry<Point2D.Double, String> entry2 : weatherRepository.getStationLocationToWeatherMap()
          .entrySet()) {
        double distance = getDistance(entry1.getKey(), entry2.getKey());
        if (distance < minDistance) {
          minDistance = distance;
          locationToWeatherMap.put(entry1.getValue(), entry2.getValue());
        }
      }
    }
    return locationToWeatherMap;
  }

  private double getDistance(Point2D point1, Point2D point2) {
    return Math.sqrt(
        Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
  }
}
