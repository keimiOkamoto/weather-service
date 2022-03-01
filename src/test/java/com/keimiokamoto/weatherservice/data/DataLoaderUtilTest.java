package com.keimiokamoto.weatherservice.data;

import static org.junit.jupiter.api.Assertions.assertFalse;

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