package volleyball.eventcalendar.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Season;
import volleyball.eventcalendar.repository.SeasonRepository;

import java.util.Optional;

@Service
public class MatchFactory {

    @Autowired
    SeasonRepository seasonRepository;

    public Season creatSeason(int seasonStartYear, int seasonEndYear) {
//        Season season = null;

        Optional<Season> dbObject = seasonRepository
                .findSeasonByStartYearAndEndYear(seasonStartYear, seasonEndYear);

//                .orElse(seasonRepository.save(
//                        Season.builder()
//                                .withStartYear(seasonStartYear)
//                                .withEndYear(seasonEndYear)
//                                .build())
//                );

        System.out.println("RESULT SEASON :  " + dbObject);
        if (!dbObject.isPresent()) {
            seasonRepository.save(Season.builder()
                    .withStartYear(seasonStartYear)
                    .withEndYear(seasonEndYear)
                    .build());
        }

        System.out.println(seasonRepository.findAll().size() + " ELEMENTS");

//        if (dbObject.isEmpty()){
//            season = seasonRepository.save(Season.builder()
//                    .withStartYear(seasonStartYear)
//                    .withEndYear(seasonEndYear)
//                    .build());
//        }

        return null;
    }
}
