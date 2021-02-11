package volleyball.eventCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volleyball.eventCalendar.athletecalendar.AthleteCalendar;
import volleyball.model.athlete.Athlete;
import volleyball.model.match.Match;
import volleyball.model.team.Team;
import volleyball.repository.Repository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EventCalendarService {

    @Autowired
    Repository repository;

    private AthleteCalendar athleteCalendar;

    public List<Match> getCalendar(Athlete athlete) {
        List<Team> teamList = athleteCalendar.getTeamList();

        Predicate<Match> isAthleteMemberOfMatchTeam = m -> teamList.contains(m.getTeam1()) || teamList.contains(m.getTeam2());

        return repository.getMatchObjects()
                .stream()
                .filter(isAthleteMemberOfMatchTeam)
                .collect(Collectors.toList());
    }

}
