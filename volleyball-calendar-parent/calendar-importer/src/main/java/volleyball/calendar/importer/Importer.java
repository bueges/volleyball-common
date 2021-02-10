package volleyball.calendar.importer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import volleyball.calendar.factory.samsFactory.SamsFactory;
import volleyball.calendar.importer.configuration.CSVConfiguration;
import volleyball.calendar.importer.configuration.Configuration;
import volleyball.calendar.tools.csvparser.CSVParser;
import volleyball.tools.downloader.FileDownloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Optional;

@Component
@Slf4j
public class Importer {

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
