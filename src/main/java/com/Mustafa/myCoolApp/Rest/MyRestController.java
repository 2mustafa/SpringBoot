package com.Mustafa.myCoolApp.Rest;
import com.Mustafa.myCoolApp.WeatherService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private final WeatherService myWeatherService;

    // The @Autowired annotation here indicates that we are using constructor injection.
    // Constructor injection means passing the dependency (in this case, a WeatherService) as a constructor parameter.
    // In other words, we are telling Spring to find a bean
    // that implements the WeatherService interface (typically annotated with @Component)
    // and pass it into this constructor when instantiating MyRestController.
    @Autowired
    public MyRestController (WeatherService theWeatherService) {
        myWeatherService = theWeatherService;
    }

/*
another approach to inject the dependency is to use setter injection:
    @Autowired
    public void setMyWeatherService(WeatherService theWeatherService) {
        myWeatherService = theWeatherService;
    }

basically in code syntax, there is no difference between constructor injection and setter injection.
it is only a naming convention that we use to differentiate between the two.
But in general, constructor injection is preferred over setter injection.
 */


    @GetMapping("/weather")
    public String getWeather() {
        return myWeatherService.getTheWeather();
    }

    // We use PostConstruct in order to execute some code after the bean has been initialized.
    // This is useful for performing any initialization tasks that we may need to do before the bean is ready to be used.
    // For example, we may want to open a database connection or start a thread.
    // here only to see the functionality of the annotation, after starting the application, we will see this message in the console.
    @PostConstruct
    public void init() {
        // Initialization code here
        System.out.println("MyRestController bean has been initialized.");
    }

    // We use PreDestroy in order to execute some code before the bean is destroyed.
    // This is useful for releasing resources that the bean may have been holding onto.
    // For example, you may want to close a database connection or stop a thread.
    // here only to see the functionality of the annotation, after stopping the application, we will see this message in the console.
    @PreDestroy
    public void cleanup() {
        // Cleanup code here
        System.out.println("MyRestController bean is being destroyed.");
    }


}
