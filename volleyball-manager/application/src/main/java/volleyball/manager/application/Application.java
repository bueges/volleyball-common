package volleyball.manager.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import volleyball.manager.application.configuration.CSVConfiguration;
import volleyball.manager.application.configuration.Configuration;
import volleyball.manager.factory.samsFactory.SamsFactory;
import volleyball.manager.tools.csvparser.CSVParser;
import volleyball.tools.downloader.FileDownloader;
import volleyball.tools.parser.IParserResult;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
//@EntityScan(basePackages = {"volleyball.model"})
//@EnableJpaRepositories(basePackages = {"volleyball.repository"})
@ComponentScan(basePackages = {"volleyball.manager", "volleyball.tools", "volleyball.repository"})
@Slf4j
public class Application {

    @Autowired
    SamsFactory samsFactory;

    @Autowired
    Configuration configuration;

    public void importData() {
        configuration.getCsvConfigurationList().stream()
                .forEach(csvConfiguration -> importCSVData(csvConfiguration));
    }

    protected void importCSVData(CSVConfiguration configuration) {
        try {
            Optional<Path> path = FileDownloader.downloadFileFromURL(new URL(configuration.getPlayingScheduleURL()));

            CSVParser csvParser = new CSVParser(configuration.getAssociationName(), path.get());
            csvParser.parseFile().stream().forEach(parserResult -> samsFactory.buildAndSaveMatchObject(parserResult));
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }


}
