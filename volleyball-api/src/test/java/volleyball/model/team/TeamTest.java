package volleyball.model.team;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import volleyball.model.athlete.Athlete;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.TEAM1_NAME;

@Slf4j
class TeamTest {

    // test parameter
    private final Competition COMPETITION = Mockito.mock(Competition.class);
    private final Club CLUB = Mockito.mock(Club.class);

    @Test
    @DisplayName("create team with valid name")
    public void createTeamWithValidName() {
        Team team = new Team(null, TEAM1_NAME, CLUB, COMPETITION, Lists.newArrayList());
        log.info("create team : {}", team);

        assertNotNull(team);

        assertNotNull(team.getName());
        assertEquals(TEAM1_NAME, team.getName());

        assertNotNull(team.getClub());
        assertTrue(team.getClub().isPresent());

        assertNotNull(team.getCompetition());
        assertTrue(team.getCompetition().isPresent());
    }

    @Test
    @DisplayName("check NullPointerException when create team with NULL name")
    public void testCheckNullPointerExceptionWhenCreateTeamWithNULLName() {
        assertThrows(NullPointerException.class, () -> new Team(null, null, CLUB, COMPETITION, Lists.newArrayList()));
    }

    @Test
    @DisplayName("create team without club")
    public void createTeamWithoutClub() {
        Team team = new Team(null, TEAM1_NAME, null, COMPETITION, Lists.newArrayList());
        log.info("create team : {}", team);

        assertNotNull(team.getClub());
        assertFalse(team.getClub().isPresent());
    }

    @Test
    @DisplayName("create team without competition")
    public void createTeamWithoutCompetition() {
        Team team = new Team(null, TEAM1_NAME, CLUB, null, Lists.newArrayList());
        log.info("create team : {}", team);

        assertNotNull(team.getCompetition());
        assertFalse(team.getCompetition().isPresent());
    }

    @Test
    @DisplayName("create team with athlete list")
    public void createTeamWithAthleteList() {
        Athlete athlete1 = Mockito.mock(Athlete.class);
        Athlete athlete2 = Mockito.mock(Athlete.class);
        Team team = new Team(null, TEAM1_NAME, CLUB, null, Lists.newArrayList(athlete1, athlete2));

        assertNotNull(team.getAthleteList());
        assertEquals(2, team.getAthleteList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getTeamName")
    @DisplayName("compare two teams with same ID")
    public void compareTwoTeamsWithSameID(String secondTeamName) {
        Team team1 = new Team(1, TEAM1_NAME, CLUB, COMPETITION, Lists.newArrayList());
        Team team2 = new Team(1, secondTeamName, CLUB, COMPETITION, Lists.newArrayList());
        Team team3 = new Team(1, secondTeamName, null, COMPETITION, Lists.newArrayList());
        Team team4 = new Team(1, secondTeamName, CLUB, null, Lists.newArrayList());

        log.info("compare team : ");
        log.info("team 1 : {}", team1);
        log.info("team 2 : {}", team2);
        log.info("team 3 : {}", team3);
        log.info("team 4 : {}", team4);

        assertEquals(team1, team2);
        assertEquals(team1, team3);
        assertEquals(team1, team4);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getTeamName")
    @DisplayName("compare two teams with different ID")
    public void compareTwoTeamsWithDifferentID(String secondTeamName) {
        Team team1 = new Team(1, TEAM1_NAME, CLUB, COMPETITION, Lists.newArrayList());
        Team team2 = new Team(2, secondTeamName, CLUB, COMPETITION, Lists.newArrayList());
        Team team3 = new Team(3, secondTeamName, null, COMPETITION, Lists.newArrayList());
        Team team4 = new Team(4, secondTeamName, CLUB, null, Lists.newArrayList());

        log.info("compare team : ");
        log.info("team 1 : {}", team1);
        log.info("team 2 : {}", team2);
        log.info("team 3 : {}", team3);
        log.info("team 4 : {}", team4);

        assertNotEquals(team1, team2);
        assertNotEquals(team1, team3);
        assertNotEquals(team1, team4);
    }
}