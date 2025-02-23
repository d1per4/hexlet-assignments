package exercise.controller;

import exercise.daytime.Daytime;
import exercise.daytime.DaytimeProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
@RequiredArgsConstructor
@RestController
public class WelcomeController{

    private final DaytimeProvider daytime;


    @GetMapping("/welcome")
    public String getDayTime(DaytimeProvider daytime){
        System.out.println("It is " + daytime.getCurrentDaytime().getName() + " now! Welcome to Spring!");
        return daytime.getCurrentDaytime().getName();
    }
}
// END
