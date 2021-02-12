package volleyball;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@SpringBootApplication
@ComponentScan(basePackages = {"volleyball.eventCalendar", "volleyball.repository"})
public class TestConfiguration {
}
