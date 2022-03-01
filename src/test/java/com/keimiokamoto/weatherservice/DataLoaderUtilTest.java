package com.keimiokamoto.weatherservice;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D.Double;
import java.util.Map;
import org.junit.jupiter.api.Test;

class DataLoaderUtilTest {

  @Test
  public void shouldLoadCityData() {
    Map<Double, String> cityLocationToCityNameMap = DataLoaderUtil.loadCities();
    assertFalse(cityLocationToCityNameMap.isEmpty());
  }

  @Test
  public void shouldLoadWeatherStationData() {
    Map<Double, String> cityLocationToCityNameMap = DataLoaderUtil.loadWeatherStations();
    assertFalse(cityLocationToCityNameMap.isEmpty());
  }
}