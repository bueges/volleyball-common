package volleyball.common.model.competitition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.common.model.season.Season;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.COMPETITION_NAME;

class CompetitionTest {

    private static final Logger logger = LogManager.getLogger(CompetitionTest.class);

    // test parameter
    private final Season SEASON = Mockito.mock(Season.class);

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getCompetitionName")
    @DisplayName("create competition")
    public void createCompetition(String name) {
        Competition competition = new Competition(name, SEASON);
        logger.info("create competition : [{}]", competition);

        assertNotNull(competition);

        assertNotNull(competition.getName());
        assertEquals(name, competition.getName());

        assertNotNull(competition.getSeason());
        assertTrue(competition.getSeason().isPresent());
    }

    @Test
    @DisplayName("create competition without season")
    public void createCompetitionWithoutSeason() {
        Competition competition = new Competition(COMPETITION_NAME, null);
        logger.info("create competition : [{}]", competition);

        assertNotNull(competition.getSeason());
        assertFalse(competition.getSeason().isPresent());
    }

    @Test
    @DisplayName("create competition with NULL name and check NullPointerException")
    public void createCompetitionWithNullName() {
        assertThrows(NullPointerException.class, () -> new Competition(null, null));
    }

    @Test
    @DisplayName("compare two equal competitions")
    public void compareTwoEqualCompetitions() {
        Competition competition1 = new Competition(COMPETITION_NAME, SEASON);
        Competition competition2 = new Competition(COMPETITION_NAME, SEASON);

        logger.info("compare competitions : ");
        logger.info("competition 1 : [{}]", competition1);
        logger.info("competition 2 : [{}]", competition2);

        assertEquals(competition1, competition2);
    }

    @Test
    @DisplayName("compare two competitions with different name")
    public void compareTwoCompetitionsWithDifferentName() {
        Competition competition1 = new Competition(COMPETITION_NAME, SEASON);
        Competition competition2 = new Competition("other-name", SEASON);

        logger.info("compare competitions : ");
        logger.info("competition 1 : [{}]", competition1);
        logger.info("competition 2 : [{}]", competition2);

        assertNotEquals(competition1, competition2);
    }

    @Test
    @DisplayName("compare two competitions with different season")
    public void compareTwoCompetitionsWithDifferentSeason() {
        Competition competition1 = new Competition(COMPETITION_NAME, SEASON);
        Competition competition2 = new Competition(COMPETITION_NAME, Mockito.mock(Season.class));

        logger.info("compare competitions : ");
        logger.info("competition 1 : [{}]", competition1);
        logger.info("competition 2 : [{}]", competition2);

        assertEquals(competition1, competition2);
    }
}