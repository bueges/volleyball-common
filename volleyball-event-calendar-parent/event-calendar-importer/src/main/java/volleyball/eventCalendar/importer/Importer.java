package volleyball.eventCalendar.importer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import volleyball.eventCalendar.factory.samsFactory.SamsFactory;
import volleyball.eventCalendar.importer.configuration.CSVConfiguration;
import volleyball.eventCalendar.importer.configuration.Configuration;
import volleyball.eventCalendar.tools.csvparser.CSVParser;
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

    /**
     * import csv data from {@link Configuration}
     */
    public void importData() {
        configuration.getCsvConfigurationList()
                .forEach(this::importCSVData);
    }

    protected void importCSVData(CSVConfiguration configuration) {
        try {
            Optional<Path> path = FileDownloader.downloadFileFromURL(new URL(configuration.getPlayingScheduleURL()));

            if (path.isPresent()) {
                CSVParser csvParser = new CSVParser(configuration.getAssociationName(), path.get());
                csvParser.parseFile().forEach(parserResult -> samsFactory.buildAndSaveMatchObject(parserResult));
            }
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
