package volleyball.eventCalendar.importer.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CSVConfiguration {

    @Value("${sams-configuration.csvConfigurationList.associationName:#{''}}")
    @Getter
    @Setter
    String associationName;

    @Value("${sams-configuration.csvConfigurationList.playingScheduleURL:#{''}}")
    @Getter
    @Setter
    String playingScheduleURL;

}
