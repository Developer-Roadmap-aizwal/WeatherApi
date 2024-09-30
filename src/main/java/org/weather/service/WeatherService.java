package org.weather.service;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.weather.model.WeatherResponse;
import org.weather.repository.WeatherRepository;

@Service
public class WeatherService {

    @Resource private WeatherRepository weatherRepository;
    @Resource private RestTemplate restTemplate;

    @Value("${visual.crossing.api.key}")
    private String visualCrossingApiKey;

    @Value("${visual.crossing.api.url}")
    private String visualCrossingApiUrl;

    public WeatherResponse getWeather(String city) {
        WeatherResponse cachedResponse = weatherRepository.findByName(city);
        if (cachedResponse != null) {
            return cachedResponse;
        }

        String url = visualCrossingApiUrl + city + "?unitGroup=metric&key=" + visualCrossingApiKey + "&contentType=json";
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        response.setName(city);
        weatherRepository.save(response);

        return response;
    }
}
