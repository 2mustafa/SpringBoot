package com.Mustafa.myCoolApp.Rest;
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

}
