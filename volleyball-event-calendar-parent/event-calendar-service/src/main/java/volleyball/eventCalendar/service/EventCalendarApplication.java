package volleyball.eventCalendar.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan(basePackages = {"volleyball.eventCalendar", "volleyball.repository"})
@EnableJpaRepositories(basePackages = "volleyball.repository")
@EntityScan("volleyball.model")
public class EventCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventCalendarApplication.class, args);
    }
}
