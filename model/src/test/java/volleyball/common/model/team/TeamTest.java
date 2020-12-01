package volleyball.common.model.team;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.common.model.competitition.Competition;
import volleyball.common.model.club.Club;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.TEAM_NAME;

class TeamTest {

    private static final Logger logger = LogManager.getLogger(TeamTest.class);

    // test parameter
    private final Competition COMPETITION = Mockito.mock(Competition.class);
    private final Club CLUB = Mockito.mock(Club.class);

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getTeamName")
    @DisplayName("create team")
    public void createTeam() {
        Team team = new Team(TEAM_NAME, CLUB, COMPETITION);
        logger.info("create team : [{}]", team);

        assertNotNull(team);

        assertNotNull(team.getName());
        assertEquals(TEAM_NAME, team.getName());

        assertNotNull(team.getClub());
        assertTrue(team.getClub().isPresent());

        assertNotNull(team.getCompetition());
        assertTrue(team.getCompetition().isPresent());
    }

    @Test
    @DisplayName("create team without club")
    public void createTeamWithoutClub() {
        Team team = new Team(TEAM_NAME, null, COMPETITION);
        logger.info("create team : [{}]", team);

        assertNotNull(team.getClub());
        assertFalse(team.getClub().isPresent());
    }

    @Test
    @DisplayName("create team without competition")
    public void createTeamWithoutCompetition() {
        Team team = new Team(TEAM_NAME, CLUB, null);
        logger.info("create team : [{}]", team);

        assertNotNull(team.getCompetition());
        assertFalse(team.getCompetition().isPresent());
    }

    @Test
    @DisplayName("create team with null name and check NullPointerException")
    public void createTeamWithInvalidNameParameter() {
        assertThrows(NullPointerException.class, () -> new Team(null, CLUB, COMPETITION));
    }

    @Test
    @DisplayName("compare two equal teams")
    public void compareTwoEqualTeams() {
        Team team1 = new Team(TEAM_NAME, CLUB, COMPETITION);
        Team team2 = new Team(TEAM_NAME, CLUB, COMPETITION);

        logger.info("compare team : ");
        logger.info("team 1 : [{}]", team1);
        logger.info("team 2 : [{}]", team2);

        assertEquals(team1, team2);
    }

    @Test
    @DisplayName("compare two teams with different names")
    public void compareTwoTeamsWithDifferentNames() {
        Team team1 = new Team(TEAM_NAME, CLUB, COMPETITION);
        Team team2 = new Team("other-name", CLUB, COMPETITION);

        logger.info("compare team : ");
        logger.info("team 1 : [{}]", team1);
        logger.info("team 2 : [{}]", team2);

        assertNotEquals(team1, team2);
    }

    @Test
    @DisplayName("compare two teams with different clubs")
    public void compareTwoTeamsWithDifferentClubs() {
        Team team1 = new Team(TEAM_NAME, CLUB, COMPETITION);
        Team team2 = new Team(TEAM_NAME, Mockito.mock(Club.class), COMPETITION);

        logger.info("compare team : ");
        logger.info("team 1 : [{}]", team1);
        logger.info("team 2 : [{}]", team2);

        assertEquals(team1, team2);
    }

    @Test
    @DisplayName("compare two teams with different competitions")
    public void compareTwoTeamsWithDifferentCompetitions() {
        Team team1 = new Team(TEAM_NAME, CLUB, COMPETITION);
        Team team2 = new Team(TEAM_NAME, CLUB, Mockito.mock(Competition.class));

        logger.info("compare team : ");
        logger.info("team 1 : [{}]", team1);
        logger.info("team 2 : [{}]", team2);

        assertEquals(team1, team2);
    }
}