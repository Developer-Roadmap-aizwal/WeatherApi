package org.weather.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.weather.model.WeatherResponse;
import org.weather.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Resource private WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherResponse getCountryWeather(@PathVariable String city){
        return weatherService.getWeather(city);
    }
}
