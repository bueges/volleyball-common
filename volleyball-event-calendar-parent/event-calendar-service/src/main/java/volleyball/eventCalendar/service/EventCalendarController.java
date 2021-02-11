package volleyball.eventCalendar.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import volleyball.eventCalendar.factory.samsFactory.SamsFactory;
import volleyball.eventCalendar.service.configuration.CSVConfiguration;
import volleyball.eventCalendar.service.configuration.Configuration;
import volleyball.eventCalendar.tools.csvparser.CSVParser;
import volleyball.tools.downloader.FileDownloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Optional;

@RestController
@Slf4j
public class EventCalendarController {

    @Autowired
    SamsFactory samsFactory;

    @Autowired
    Configuration configuration;

    @GetMapping("/init")
    public void init() {
        configuration.getCsvConfigurationList()
                .forEach(configuration -> {
                            try {
                                Optional<Path> path = FileDownloader.downloadFileFromURL(new URL(configuration.getPlayingScheduleURL()));

                                if (path.isPresent()) {
                                    log.info("import event data from {}", path.get().toFile().getPath());
                                    CSVParser csvParser = new CSVParser(configuration.getAssociationName(), path.get());
                                    csvParser.parseFile().forEach(eventData -> samsFactory.buildAndSaveMatchObject(eventData));
                                }
                            } catch (MalformedURLException e) {
                                log.error(e.getMessage());
                                e.printStackTrace();
                            }
                        }
                );
    }

}
