package com.keimiokamoto.weatherservice.domain;

import java.awt.geom.Point2D.Double;
import java.util.Objects;

public class CityLocation {

  private final String cityName;
  private final Double point;

  public CityLocation(String cityName, Double point) {
    this.cityName = cityName;
    this.point = point;
  }

  public String getCityName() {
    return cityName;
  }

  public Double getPoint() {
    return point;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CityLocation)) {
      return false;
    }
    CityLocation that = (CityLocation) o;
    return Objects.equals(getCityName(), that.getCityName()) && Objects
        .equals(getPoint(), that.getPoint());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCityName(), getPoint());
  }

  @Override
  public String toString() {
    return "CityLocation{" +
        "cityName='" + cityName + '\'' +
        ", point=" + point +
        '}';
  }
}
