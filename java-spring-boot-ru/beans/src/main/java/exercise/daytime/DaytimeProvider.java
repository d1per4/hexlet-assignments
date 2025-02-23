package exercise.daytime;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DaytimeProvider {
    public Daytime getCurrentDaytime() {
        int hour = LocalDateTime.now().getHour();
        return (hour >= 6 && hour < 22) ? new Day() : new Night();
    }
}
