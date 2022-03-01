package com.keimiokamoto.weatherservice.domain;

import java.awt.geom.Point2D;
import java.util.Objects;

public class WeatherStation {

  private final Point2D.Double point;
  private final String weatherDescription;

  public WeatherStation(Point2D.Double point, String weatherDescription) {
    this.point = point;
    this.weatherDescription = weatherDescription;
  }

  public Point2D.Double getPoint() {
    return point;
  }

  public String getWeatherDescription() {
    return weatherDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WeatherStation)) {
      return false;
    }
    WeatherStation that = (WeatherStation) o;
    return Objects.equals(getPoint(), that.getPoint()) && Objects
        .equals(getWeatherDescription(), that.getWeatherDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPoint(), getWeatherDescription());
  }

  @Override
  public String toString() {
    return "WeatherStation{" +
        "point=" + point +
        ", weatherDescription='" + weatherDescription + '\'' +
        '}';
  }
}
