package volleyball.eventCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class EventCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventCalendarApplication.class, args);
    }
}
