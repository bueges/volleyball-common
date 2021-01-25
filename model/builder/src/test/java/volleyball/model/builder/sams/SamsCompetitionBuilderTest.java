package volleyball.model.builder.sams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.builder.competition.Competition;
import volleyball.model.builder.season.Season;

import java.util.Optional;

import static volleyball.TestConstants.CLUB1_NAME;

class SamsCompetitionBuilderTest {

    // object under test
    private SamsCompetitionBuilder builder = new SamsCompetitionBuilder();

    @Test
    @DisplayName("build competition object with valid data")
    public void testBuildCompetitionObjectWithValidData() {
        Optional<Competition> competition = builder
                .withName(CLUB1_NAME)
                .withSeason(Mockito.mock(Season.class))
                .build();

        Assertions.assertNotNull(competition);
        Assertions.assertTrue(competition.isPresent());
    }

    @Test
    @DisplayName("build competition object without season")
    public void testBuildCompetitionObjectWithoutSeason() {
        Optional<Competition> competition = builder
                .withName(CLUB1_NAME)
                .build();

        Assertions.assertNotNull(competition);
        Assertions.assertFalse(competition.isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getInvalidCompetitionName")
    @DisplayName("build competition object with invalid name")
    public void testBuildCompetitionObjectWithInvalidName(String name) {
        Optional<Competition> competition = builder
                .withName(name)
                .build();

        Assertions.assertNotNull(competition);
        Assertions.assertFalse((competition.isPresent()));
    }
}