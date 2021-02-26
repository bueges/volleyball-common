package volleyball.eventcalendar.factory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Club;
import volleyball.eventcalendar.entity.Competition;
import volleyball.eventcalendar.entity.Team;
import volleyball.eventcalendar.repository.TeamRepository;

import java.util.Optional;

@AllArgsConstructor
@Component
public class TeamFactory {

    private TeamRepository repository;

    public Team createTeam(String teamName, Club club, Competition competition) {
        Optional<Team> dbObject = repository
                .findTeamByNameAndClubAndCompetition(teamName, club, competition);

        if (dbObject.isPresent()) {
            return dbObject.get();
        } else {
            return repository.save(Team.builder()
                    .withName(teamName)
                    .withClub(club)
                    .withCompetition(competition)
                    .build());
        }
    }
}
