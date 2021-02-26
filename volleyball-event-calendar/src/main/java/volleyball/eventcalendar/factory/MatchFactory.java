package volleyball.eventcalendar.factory;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.*;
import volleyball.eventcalendar.repository.*;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Component
public class MatchFactory {

    private MatchRepository repository;

    public Match createMatch(LocalDateTime dateTime, String number, Team team1, Team team2, Result result) {
        Optional<Match> dbObject = repository.findMatchByDateTimeAndNumberAndTeam1AndTeam2(dateTime, number, team1, team2);

        if (dbObject.isPresent()) {
            return dbObject.get();
        } else {
            return repository.save(Match.builder()
                    .withDateTime(dateTime)
                    .withNumber(number)
                    .withTeam1(team1)
                    .withTeam2(team2)
                    .withResult(result)
                    .build());
        }
    }
}
