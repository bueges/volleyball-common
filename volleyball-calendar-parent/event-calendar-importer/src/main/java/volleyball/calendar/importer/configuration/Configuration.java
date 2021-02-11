package volleyball.calendar.importer.configuration;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("sams-configuration")
public class Configuration {

    @Getter
    List<CSVConfiguration> csvConfigurationList = Lists.newArrayList();
}
