package org.weather.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@Data
@RedisHash("weather")
public class WeatherResponse {
    @Id
    private String id;
    @Indexed
    private String name;
    private String resolvedAddress;
    private double latitude;
    private double longitude;
    private String timezone;
    private String currentTime;
    private List<Day> days;

    @Data
    public static class Day {
        private String datetime;
        private int temperature;
        private int feelslike;
        private int humidity;
        private int wind;
        private String conditions;
    }
}
