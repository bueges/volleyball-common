package volleyball.eventcalendar.factory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Association;
import volleyball.eventcalendar.entity.Season;
import volleyball.eventcalendar.repository.SeasonRepository;

import java.util.Optional;

@AllArgsConstructor
@Component
public class SeasonFactory {

    private SeasonRepository repository;

    public Season creatSeason(int seasonStartYear, int seasonEndYear, Association association) {
        Optional<Season> dbObject = repository
                .findSeasonByStartYearAndEndYearAndAssociation(seasonStartYear, seasonEndYear, association);

        if (dbObject.isPresent()) {
            return dbObject.get();
        } else {
            return repository.save(Season.builder()
                    .withStartYear(seasonStartYear)
                    .withEndYear(seasonEndYear)
                    .withAssociation(association)
                    .build());
        }
    }
}
