package volleyball.model.builder.sams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.builder.club.Club;
import volleyball.model.builder.competition.Competition;
import volleyball.model.builder.team.Team;

import java.util.Optional;

import static volleyball.TestConstants.TEAM1_NAME;

class SamsTeamBuilderTest {

    // object under test
    private SamsTeamBuilder builder = new SamsTeamBuilder();

    @Test
    @DisplayName("build team object with valid data")
    public void testBuildTeamObjectWithValidData() {
        Optional<Team> team = builder
                .withName(TEAM1_NAME)
                .withClub(Mockito.mock(Club.class))
                .withCompetition(Mockito.mock(Competition.class))
                .build();

        Assertions.assertNotNull(team);
        Assertions.assertTrue(team.isPresent());
    }

    @Test
    @DisplayName("build team object without club")
    public void testBuildTeamObjectWithoutClub() {
        Optional<Team> team = builder
                .withName(TEAM1_NAME)
                .withCompetition(Mockito.mock(Competition.class))
                .build();

        Assertions.assertNotNull(team);
        Assertions.assertFalse(team.isPresent());
    }

    @Test
    @DisplayName("build team object without competition")
    public void testBuildTeamObjectWithoutCompetition() {
        Optional<Team> team = builder
                .withName(TEAM1_NAME)
                .withClub(Mockito.mock(Club.class))
                .build();

        Assertions.assertNotNull(team);
        Assertions.assertFalse(team.isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getInvalidTeamName")
    @DisplayName("build team object with invalid name")
    public void testBuildTeamObjectWithInvalidName(String name) {
        Optional<Team> team = builder
                .withName(name)
                .withClub(Mockito.mock(Club.class))
                .withCompetition(Mockito.mock(Competition.class))
                .build();

        Assertions.assertNotNull(team);
        Assertions.assertFalse(team.isPresent());
    }
}