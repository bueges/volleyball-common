package volleyball.common.model.team;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.common.builder.BuilderException;
import volleyball.common.model.competitition.Competition;
import volleyball.common.model.club.Club;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.TEAM_NAME;

class TeamBuilderTest {

    private static final Logger logger = LogManager.getLogger(TeamBuilderTest.class);

    // test parameter
    private final Club CLUB = Mockito.mock(Club.class);
    private final Competition COMPETITION = Mockito.mock(Competition.class);

    @Test
    @DisplayName("build team")
    public void buildTeam() throws BuilderException {
        Team team = Team.builder()
                .withName(TEAM_NAME)
                .withClub(CLUB)
                .withCompetition(COMPETITION)
                .build();
        logger.info("build team : [{}]", team);

        assertNotNull(team);

        assertNotNull(team.getName());
        assertEquals(TEAM_NAME, team.getName());

        assertNotNull(team.getClub());
        assertTrue(team.getClub().isPresent());

        assertNotNull(team.getCompetition());
        assertTrue(team.getCompetition().isPresent());
    }

    @Test
    @DisplayName("build team without club")
    public void buildTeamWithoutClub() throws BuilderException {
        Team team = Team.builder()
                .withName(TEAM_NAME)
                .withCompetition(COMPETITION)
                .build();
        logger.info("build team : [{}]", team);

        assertNotNull(team.getClub());
        assertFalse(team.getClub().isPresent());
    }

    @Test
    @DisplayName("build team without competition")
    public void buildTeamWithoutCompetition() throws BuilderException {
        Team team = Team.builder()
                .withName(TEAM_NAME)
                .withClub(CLUB)
                .build();
        logger.info("build team : [{}]", team);

        assertNotNull(team.getCompetition());
        assertFalse(team.getCompetition().isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getTeamBuilderName")
    @DisplayName("build team with invalid name and check BuilderException")
    public void buildTeamWithInvalidName(String name) {
        assertThrows(BuilderException.class, () -> Team.builder()
                .withName(name)
                .build());
    }
}