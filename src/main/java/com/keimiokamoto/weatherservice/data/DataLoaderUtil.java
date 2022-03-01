package com.keimiokamoto.weatherservice.data;

import static java.lang.Double.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keimiokamoto.weatherservice.domain.CityLocation;
import com.keimiokamoto.weatherservice.domain.WeatherStation;
import java.awt.geom.Point2D.Double;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoaderUtil {

  private static final String WEATHER_STATION_FILE_NAME = "WeatherStations.json";
  private static final String CITIES_FILE_NAME = "Cities.json";

  public static Map<Double, String> loadCities() {
    JSONArray jsonArray = parseJsonStringToJsonArray(CITIES_FILE_NAME);
    return (Map<Double, String>) jsonArray.stream()
        .map(jsonObj -> getCityLocation(jsonObj))
        .collect(Collectors.toMap(CityLocation::getPoint, CityLocation::getCityName));
  }

  public static Map<Double, String> loadWeatherStations() {
    JSONArray jsonArray = parseJsonStringToJsonArray(WEATHER_STATION_FILE_NAME);
    return (Map<Double, String>) jsonArray.stream()
        .map(jsonObj -> createWeatherStation((JSONObject) jsonObj))
        .collect(Collectors
            .toMap(WeatherStation::getPoint, WeatherStation::getWeatherDescription));
  }

  private static JSONArray parseJsonStringToJsonArray(String fileName) {
    try {
      return (JSONArray) new JSONParser().parse(getResourceFileAsString(fileName));
    } catch (ParseException e) {
      throw new RuntimeException("Something went wrong whilst trying to parse " + fileName, e);
    }
  }

  private static CityLocation getCityLocation(Object line) {
    try {
      Map<String, Object> result = new ObjectMapper().readValue(line.toString(), HashMap.class);
      return result.entrySet().stream().map(e -> createCityLocation(e)).collect(Collectors.toList())
          .get(0);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Something went wrong whilst trying to parse " + CITIES_FILE_NAME,
          e);
    }
  }

  private static CityLocation createCityLocation(Map.Entry<String, Object> e) {
    double longitude = (java.lang.Double) ((ArrayList) e.getValue()).get(0);
    double latitude = (java.lang.Double) ((ArrayList) e.getValue()).get(1);
    return new CityLocation(e.getKey(), new Double(longitude, latitude));
  }

  private static WeatherStation createWeatherStation(JSONObject weatherStationData) {
    return new WeatherStation(
        new Double(parseDouble(String.valueOf(weatherStationData.get("lng"))),
            parseDouble(String.valueOf(weatherStationData.get("lat")))),
        (String) weatherStationData.get("weather"));
  }

  private static String getResourceFileAsString(String fileName) {
    InputStream is = getResourceFileAsInputStream(fileName);
    if (is != null) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    } else {
      throw new RuntimeException("Resource not found for file named: " + fileName);
    }
  }

  private static InputStream getResourceFileAsInputStream(String fileName) {
    ClassLoader classLoader = DataLoaderUtil.class.getClassLoader();
    return classLoader.getResourceAsStream(fileName);
  }
}

