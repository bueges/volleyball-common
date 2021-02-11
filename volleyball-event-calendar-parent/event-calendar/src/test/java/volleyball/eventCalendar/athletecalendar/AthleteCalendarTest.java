package volleyball.eventCalendar.athletecalendar;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import volleyball.model.athlete.Athlete;
import volleyball.model.team.Team;

import static org.junit.jupiter.api.Assertions.*;

class AthleteCalendarTest {

    @Test
    @DisplayName("create athlete calendar")
    public void createAthleteCalendar() {
        AthleteCalendar athleteCalendar = new AthleteCalendar(Mockito.mock(Athlete.class),
                Lists.newArrayList(Mockito.mock(Team.class), Mockito.mock(Team.class)));

        assertNotNull(athleteCalendar.getAthlete());

        assertNotNull(athleteCalendar.getTeamList());
        assertEquals(2, athleteCalendar.getTeamList().size());
    }

    @Test
    @DisplayName("check NullPointerException when create athlete calendar with NULL athlete")
    public void buildAthleteCalendarWithNULLAthlete() {
        assertThrows(NullPointerException.class, () -> new AthleteCalendar(null, Lists.newArrayList()));
    }

    @Test
    @DisplayName("create athlete calendar without teams")
    public void createAthleteCalendarWithoutTeams() {
        AthleteCalendar athleteCalendar = new AthleteCalendar(Mockito.mock(Athlete.class), Lists.newArrayList());

        assertNotNull(athleteCalendar.getAthlete());

        assertNotNull(athleteCalendar.getTeamList());
        assertEquals(0, athleteCalendar.getTeamList().size());
    }
}