package volleyball.model.builder.season;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.builder.association.Association;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestConstants.SEASON_END_YEAR;
import static volleyball.TestConstants.SEASON_START_YEAR;

class SeasonTest {

    private static final Logger logger = LogManager.getLogger(SeasonTest.class);

    // test parameter
    private final Association ASSOCIATION = Mockito.mock(Association.class);

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getSeasonPeriod")
    @DisplayName("create season")
    public void createSeason(Pair<Integer, Integer> period) {
        Season season = new Season(period.getLeft(), period.getRight(), ASSOCIATION);
        logger.info("create season : {}", season);

        assertNotNull(season);

        assertEquals(period.getLeft().intValue(), season.getStartYear());
        assertEquals(period.getRight().intValue(), season.getEndYear());

        assertNotNull(season.getAssociation());
        assertTrue(season.getAssociation().isPresent());
    }

    @Test
    @DisplayName("create season without association")
    public void createSeasonWithoutAssociation() {
        Season season = new Season(SEASON_START_YEAR, SEASON_END_YEAR, null);
        logger.info("create season : {}", season);

        assertNotNull(season.getAssociation());
        assertFalse(season.getAssociation().isPresent());
    }

    @Test
    @DisplayName("compare two equal seasons")
    public void compareTwoEqualSeasons() {
        Season season1 = new Season(SEASON_START_YEAR, SEASON_END_YEAR, ASSOCIATION);
        Season season2 = new Season(SEASON_START_YEAR, SEASON_END_YEAR, ASSOCIATION);

        logger.info("compare  season : ");
        logger.info("season 1 : {}", season1);
        logger.info("season 2 : {}", season2);

        assertEquals(season1, season2);
    }

    @Test
    @DisplayName("compare two seasons with different periods")
    public void compareTwoSeasonsWithDifferentPeriods() {
        Season season1 = new Season(SEASON_START_YEAR, SEASON_END_YEAR, ASSOCIATION);
        Season season2 = new Season(SEASON_START_YEAR - 1, SEASON_END_YEAR - 1, ASSOCIATION);

        logger.info("compare  season : ");
        logger.info("season 1 : {}", season1);
        logger.info("season 2 : {}", season2);

        assertNotEquals(season1, season2);
    }

    @Test
    @DisplayName("compare two seasons with different associations")
    public void compareTwoSeasonsWithDifferentAssociations() {
        Season season1 = new Season(SEASON_START_YEAR, SEASON_END_YEAR, ASSOCIATION);
        Season season2 = new Season(SEASON_START_YEAR, SEASON_END_YEAR, Mockito.mock(Association.class));

        logger.info("compare  season : ");
        logger.info("season 1 : {}", season1);
        logger.info("season 2 : {}", season2);

        assertEquals(season1, season2);
    }
}