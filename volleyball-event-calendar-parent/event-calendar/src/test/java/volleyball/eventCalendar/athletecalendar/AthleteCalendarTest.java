package volleyball.eventCalendar.athletecalendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import volleyball.model.team.Team;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AthleteCalendarTest {

    @Test
    @DisplayName("add and remove team to athlete calendar")
    public void addAndRemoveTeamToAthleteCalendar() {
        Team team1 = Mockito.mock(Team.class);
        Team team2 = Mockito.mock(Team.class);

        AthleteCalendar athleteCalendar = new AthleteCalendar();

        assertNotNull(athleteCalendar.getAthlete());

        athleteCalendar.addTeam(team1);
        athleteCalendar.addTeam(team2);
        assertEquals(2, athleteCalendar.getTeamList().size());

        athleteCalendar.addTeam(team1);
        assertEquals(2, athleteCalendar.getTeamList().size());

        athleteCalendar.removeTeam(team1);
        athleteCalendar.removeTeam(team2);
        assertEquals(0, athleteCalendar.getTeamList().size());

        athleteCalendar.removeTeam(team1);
    }
}