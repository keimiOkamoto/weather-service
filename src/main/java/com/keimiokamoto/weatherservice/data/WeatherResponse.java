package com.keimiokamoto.weatherservice.data;

import java.util.Objects;

public class WeatherResponse {

  private final String city;
  private final String weather;

  public WeatherResponse(String city, String weather) {
    this.city = city;
    this.weather = weather;
  }

  public String getCity() {
    return city;
  }

  public String getWeather() {
    return weather;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WeatherResponse)) {
      return false;
    }
    WeatherResponse that = (WeatherResponse) o;
    return getCity().equals(that.getCity()) && getWeather().equals(that.getWeather());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCity(), getWeather());
  }

  @Override
  public String toString() {
    return "WeatherResponse{" +
        "city='" + city + '\'' +
        ", weather='" + weather + '\'' +
        '}';
  }
}
