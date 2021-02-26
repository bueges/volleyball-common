package volleyball.eventcalendar;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import volleyball.eventcalendar.entity.Association;
import volleyball.eventcalendar.entity.Season;
import volleyball.eventcalendar.factory.MatchFactory;
import volleyball.eventcalendar.service.DataService;

@SpringBootApplication
public class VolleyballEventCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolleyballEventCalendarApplication.class, args);
    }

    @Bean
    public ApplicationRunner init(DataService dataService) {
        return args -> {
            dataService.init();
        };
    }
}
