package com.Mustafa.myCoolApp;

import org.springframework.stereotype.Component;

// This annotation marks the class as a "spring bean" so would be automatically discovered by spring.
// This way would it be ready to be injected into other classes
@Component
public class Todaysweather implements WeatherService {

    @Override
    public String getTheWeather() {
        return "Today is sunny!";
    }
}
