package org.weather.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;
import org.weather.model.WeatherResponse;

@Repository
public interface WeatherRepository extends KeyValueRepository<WeatherResponse, String> {
    WeatherResponse findByName(String city);
}
