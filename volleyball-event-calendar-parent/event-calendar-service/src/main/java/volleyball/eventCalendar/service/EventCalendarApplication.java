package volleyball.eventCalendar.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"volleyball.eventCalendar", "volleyball.repository"})
public class EventCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventCalendarApplication.class, args);
    }
}
