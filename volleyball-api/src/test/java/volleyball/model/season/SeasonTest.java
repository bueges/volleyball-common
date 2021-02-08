package volleyball.model.season;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.data.util.Pair;
import volleyball.model.association.Association;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.SEASON_END_YEAR;
import static volleyball.TestData.SEASON_START_YEAR;

@Slf4j
class SeasonTest {

    // test parameter
    private final Association ASSOCIATION = Mockito.mock(Association.class);

    @Test
    @DisplayName("create season")
    public void createSeason() {
        Season season = new Season(null, SEASON_START_YEAR, SEASON_END_YEAR, ASSOCIATION);
        log.info("create season : {}", season);

        assertNotNull(season);

        assertEquals(SEASON_START_YEAR, season.getStartYear());
        assertEquals(SEASON_END_YEAR, season.getEndYear());

        assertNotNull(season.getAssociation());
        assertTrue(season.getAssociation().isPresent());
    }

    @Test
    @DisplayName("create season without association")
    public void createSeasonWithoutAssociation() {
        Season season = new Season(null, SEASON_START_YEAR, SEASON_END_YEAR, null);
        log.info("create season : {}", season);

        assertNotNull(season.getAssociation());
        assertFalse(season.getAssociation().isPresent());
    }


    @ParameterizedTest
    @MethodSource("volleyball.TestData#getSeasonPeriod")
    @DisplayName("compare seasons with same ID")
    public void compareSeasonsWithSameID(Pair<Integer, Integer> otherSeasonPeriod) {
        Season season1 = new Season(1, SEASON_START_YEAR, SEASON_END_YEAR, ASSOCIATION);
        Season season2 = new Season(1, otherSeasonPeriod.getFirst(), otherSeasonPeriod.getSecond(), ASSOCIATION);
        Season season3 = new Season(1, otherSeasonPeriod.getFirst(), otherSeasonPeriod.getSecond(), null);

        log.info("compare  season : ");
        log.info("season 1 : {}", season1);
        log.info("season 2 : {}", season2);
        log.info("season 3 : {}", season3);

        assertEquals(season1, season2);
        assertEquals(season1, season3);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getSeasonPeriod")
    @DisplayName("compare seasons with different ID")
    public void compareSeasonsWithDifferentID(Pair<Integer, Integer> otherSeasonPeriod) {
        Season season1 = new Season(1, SEASON_START_YEAR, SEASON_END_YEAR, ASSOCIATION);
        Season season2 = new Season(2, otherSeasonPeriod.getFirst(), otherSeasonPeriod.getSecond(), ASSOCIATION);
        Season season3 = new Season(3, otherSeasonPeriod.getFirst(), otherSeasonPeriod.getSecond(), null);

        log.info("compare  season : ");
        log.info("season 1 : {}", season1);
        log.info("season 2 : {}", season2);
        log.info("season 3 : {}", season3);

        assertNotEquals(season1, season2);
        assertNotEquals(season1, season3);
    }
}