package volleyball;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"volleyball.eventCalendar", "volleyball.repository"})
public class TestConfiguration {
}
