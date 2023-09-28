package com.Mustafa.myCoolApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
// This annotation marks this class as the primary implementation of the WeatherService interface.
// We use @Primary when we have multiple implementations of the same interface and we want to tell spring which one to use.
// Here we have two implementations of the WeatherService interface: Todaysweather, Tomorrowsweather and Yesterdaysweather.
// with the help of @Primary we tell spring to use the implementation of the WeatherService interface that is annotated with @Primary.
public class Tomorrowsweather implements WeatherService{
    @Override
    public String getTheWeather() {
             return "tomorrow would be sunny!";
    }
}
