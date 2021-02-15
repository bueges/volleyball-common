package volleyball.eventCalendar.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volleyball.eventCalendar.factory.samsFactory.SamsFactory;
import volleyball.eventCalendar.service.configuration.Configuration;
import volleyball.eventCalendar.tools.csvparser.CSVParser;
import volleyball.model.athlete.Athlete;
import volleyball.model.event.Event;
import volleyball.repository.Repository;
import volleyball.tools.downloader.FileDownloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EventCalendarService {

    @Autowired
    SamsFactory samsFactory;

    @Autowired
    Configuration configuration;

    @Autowired
    Repository repository;

    /**
     * download and import all event data from configuration
     */
    @Autowired
    public void init() {
        log.debug("init event calendar service");

        configuration.getCsvConfigurationList()
                .forEach((config) -> {
                            try {
                                Optional<Path> path = FileDownloader.downloadFileFromURL(new URL(config.getPlayingScheduleURL()));

                                if (path.isPresent()) {
                                    log.info("import event data from {}", path.get().toFile().getPath());
                                    samsFactory.parseDataAndSaveEventObjects(new CSVParser(config.getAssociationName(), path.get()));
                                }
                            } catch (MalformedURLException e) {
                                log.error(e.getMessage());
                                e.printStackTrace();
                            }
                        }
                );
    }

    public List<Event> getAthleteCalendar(Athlete athlete) {
        Predicate<Event> isAthleteMemberOfEventMatch = e -> e.getMatch().getTeam1().getAthleteList().contains(athlete) ||
                e.getMatch().getTeam2().getAthleteList().contains(athlete);

        return repository.getEventObjects()
                .stream()
                .filter(isAthleteMemberOfEventMatch)
                .collect(Collectors.toList());
    }
}
