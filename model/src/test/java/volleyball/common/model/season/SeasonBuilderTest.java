package volleyball.common.model.season;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.common.builder.BuilderException;
import volleyball.common.model.association.Association;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.*;

class SeasonBuilderTest {

    private static final Logger logger = LogManager.getLogger(SeasonBuilderTest.class);

    @Test
    @DisplayName("build season")
    public void buildSeason() throws BuilderException {
        Season season = Season.builder()
                .withPeriod(SEASON_PERIOD_TEXT)
                .withAssociation(Mockito.mock(Association.class))
                .build();
        logger.info("build season : [{}]", season);

        assertEquals(SEASON_PERIOD_START, season.getPeriodStart());

        assertEquals(SEASON_PERIOD_END, season.getPeriodEnd());

        assertNotNull(season.getAssociation());
        assertTrue(season.getAssociation().isPresent());
    }

    @Test
    @DisplayName("build season without association")
    public void buildSeasonWithoutAssociation() throws BuilderException {
        Season season = Season.builder()
                .withPeriod(SEASON_PERIOD_TEXT)
                .build();
        logger.info("build season : [{}]", season);

        assertNotNull(season.getAssociation());
        assertFalse(season.getAssociation().isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getSeasonBuilderPeriod")
    @DisplayName("build season with invalid period and check BuilderException")
    public void buildSeasonWithInvalidPeriod(String period) {
        assertThrows(BuilderException.class, () -> Season.builder()
                .withPeriod(period)
                .build());
    }
}