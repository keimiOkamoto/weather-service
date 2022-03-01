package com.keimiokamoto.weatherservice.data;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherRepository {

  private static volatile Map<Point2D.Double, String> stationLocationToWeatherMap = new HashMap<>();
  private static volatile Map<Point2D.Double, String> cityLocationToCityNameMap = new HashMap<>();

  public WeatherRepository() {
    stationLocationToWeatherMap = DataLoaderUtil.loadWeatherStations();
    cityLocationToCityNameMap = DataLoaderUtil.loadCities();
  }

  public Map<Point2D.Double, String> getStationLocationToWeatherMap() {
    return stationLocationToWeatherMap;
  }

  public Map<Point2D.Double, String> getCityLocationToCityNameMap() {
    return cityLocationToCityNameMap;
  }
}
