package volleyball.eventCalendar.athletecalendar;

import com.google.common.collect.Lists;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import volleyball.eventCalendar.IEventCalendar;
import volleyball.model.athlete.Athlete;
import volleyball.model.match.Match;
import volleyball.model.team.Team;
import volleyball.repository.Repository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Slf4j
public class AthleteCalendar implements IEventCalendar {

    @Autowired
    Repository repository;

    @NonNull
    @Getter
    @EqualsAndHashCode.Exclude
    private Athlete athlete;

    @Getter
    @EqualsAndHashCode.Exclude
    private List<Team> teamList = Lists.newArrayList();

    /**
     * add an team reference to the list
     *
     * @param team the {@link Team} object to add
     */
    public void addTeam(Team team) {
        if (!teamList.contains(team)) {
            log.info("add team {} to teamlist.", team);
            teamList.add(team);
        }
    }

    /**
     * remove a team reference from the list
     *
     * @param team -  the {@link Team} object to remove
     */
    public void removeTeam(Team team) {
        if (teamList.contains(team)) {
            log.info("remove team {} from teamlist.", team);
            teamList.remove(team);
        }
    }

    public List<Match> getCalendar() {
        Predicate<Match> isAthleteMemberOfMatchTeam = m -> teamList.contains(m.getTeam1()) || teamList.contains(m.getTeam2());

        return repository.getMatchObjects()
                .stream()
                .filter(isAthleteMemberOfMatchTeam)
                .collect(Collectors.toList());
    }
}
