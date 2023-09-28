package com.Mustafa.myCoolApp;

import org.springframework.stereotype.Component;

@Component
public class Yesterdaysweather implements WeatherService{
    @Override
    public String getTheWeather() {
        return "yesterday was it sunny!";
    }
}
