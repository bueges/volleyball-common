package volleyball.eventcalendar.factory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import volleyball.eventcalendar.entity.Association;
import volleyball.eventcalendar.entity.Competition;
import volleyball.eventcalendar.entity.Season;
import volleyball.eventcalendar.repository.CompetitionRepository;

import java.util.Optional;

@AllArgsConstructor
@Component
public class CompetitionFactory {

    private CompetitionRepository repository;

    public Competition createCompetition(String competitionName, Season season) {
        Optional<Competition> dbObject = repository
                .findCompetitionByNameAndSeason(competitionName, season);

        if (dbObject.isPresent()) {
            return dbObject.get();
        } else {
            return repository.save(Competition.builder()
                    .withName(competitionName)
                    .withSeason(season)
                    .build());
        }
    }
}
