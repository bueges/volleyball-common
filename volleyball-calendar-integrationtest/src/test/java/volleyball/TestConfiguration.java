package volleyball;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"volleyball.calendar", "volleyball.repository"})
public class TestConfiguration {
}
