package volleyball.calendar.athletecalendar;

import lombok.*;
import volleyball.model.athlete.Athlete;
import volleyball.model.team.Team;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class AthleteCalendar {

    private Athlete athlete;

    private List<Team> teamList;
}
