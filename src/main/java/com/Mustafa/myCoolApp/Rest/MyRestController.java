package com.Mustafa.myCoolApp.Rest;
import com.Mustafa.myCoolApp.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // this anotation is used to make this class as a rest controller
public class MyRestController { // the class name as "RestController" will cause conflict with the class name in the main class
    @GetMapping("/")
    public String sayHello() {
        return "Hello World From Rest Controller!!!!! ";
    }




    //@ReqestParam is used to get the parameter from the url
    //like this: http://localhost:8080/name?name=Mustafa
    @GetMapping("/name")
    public String sayMyName(@RequestParam String name) {
        return "hello " + name;
    }


    // Injecting custom properties from application.properties file
    @Value("${owner.name}")
    private String ownerName;
    @Value("${owner.phone}")
    private String ownerPhone;

    @GetMapping("/ownerinfo")
    public String getOwnerInfo() {
        return "Owner name: " + ownerName + " Owner phone: " + ownerPhone;
    }


    // Create an object from the interface WeatherService
    // Define a constructor for dependency injection
    private WeatherService myWeatherService;

    // The @Autowired annotation here indicates that we are using constructor injection.
    // Constructor injection means passing the dependency (in this case, a WeatherService) as a constructor parameter.
    // In other words, we are telling Spring to find a bean
    // that implements the WeatherService interface (typically annotated with @Component)
    // and pass it into this constructor when instantiating MyRestController.
    @Autowired
    public MyRestController (WeatherService theWeatherService) {
        myWeatherService = theWeatherService;
    }

    @GetMapping("/weather")
    public String getDailyWorkout() {
           return myWeatherService.getTheWeather();
}

}
