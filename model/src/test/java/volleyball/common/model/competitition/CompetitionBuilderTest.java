package volleyball.common.model.competitition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.common.builder.BuilderException;
import volleyball.common.model.TestParameter;
import volleyball.common.model.season.Season;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionBuilderTest {

    private static final Logger logger = LogManager.getLogger(CompetitionBuilderTest.class);

    // test parameter
    private final Season SEASON = Mockito.mock(Season.class);

    @Test
    @DisplayName("build competition")
    public void buildCompetition() throws BuilderException {
        Competition competition = Competition.builder()
                .withName(TestParameter.COMPETITION_NAME)
                .withSeason(SEASON).build();
        logger.info("build competition : [{}]", competition);

        assertNotNull(competition);

        assertNotNull(competition.getName());
        assertEquals(TestParameter.COMPETITION_NAME, competition.getName());

        assertNotNull(competition.getSeason());
        assertTrue(competition.getSeason().isPresent());
    }

    @Test
    @DisplayName("build competition without season")
    public void buildCompetitionWithoutSeason() throws BuilderException {
        Competition competition = Competition.builder()
                .withName(TestParameter.COMPETITION_NAME)
                .build();
        logger.info("build competition : [{}]", competition);

        assertNotNull(competition.getSeason());
        assertFalse(competition.getSeason().isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getCompetitionBuilderName")
    @DisplayName("build competition with invalid name and check BuilderException")
    public void buildCompetitionWithInvalidName(String name) {
        assertThrows(BuilderException.class, () -> Competition.builder().withName(name).build());
    }
}