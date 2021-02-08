package volleyball.model.competition;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.season.Season;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.COMPETITION_NAME;

@Slf4j
class CompetitionTest {

    // test parameter
    private final Season SEASON = Mockito.mock(Season.class);

    @Test
    @DisplayName("create competition with valid name")
    public void createCompetitionWithValidName() {
        Competition competition = new Competition(null, COMPETITION_NAME, SEASON);
        log.info("create competition : {}", competition);

        assertNotNull(competition);

        assertNotNull(competition.getName());
        assertEquals(COMPETITION_NAME, competition.getName());

        assertNotNull(competition.getSeason());
        assertTrue(competition.getSeason().isPresent());
    }

    @Test
    @DisplayName("check NullPointerException when create competition with NULL name")
    public void testCheckNullPointerExceptionWhenCreateCompetitionWithNULLName() {
        assertThrows(NullPointerException.class, () -> new Competition(null, null, SEASON));
    }

    @Test
    @DisplayName("create competition without season object")
    public void createCompetitionWithoutSeasonObject() {
        Competition competition = new Competition(null, COMPETITION_NAME, null);
        log.info("create competition : {}", competition);

        assertNotNull(competition.getSeason());
        assertFalse(competition.getSeason().isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getCompetitionName")
    @DisplayName("compare competitions with same ID")
    public void compareCompetitionsWithSameID(String otherCompetitionName) {
        Competition competition1 = new Competition(1, COMPETITION_NAME, SEASON);
        Competition competition2 = new Competition(1, otherCompetitionName, SEASON);
        Competition competition3 = new Competition(1, otherCompetitionName, null);

        log.info("compare competitions : ");
        log.info("competition 1 : {}", competition1);
        log.info("competition 2 : {}", competition2);
        log.info("competition 3 : {}", competition3);

        assertEquals(competition1, competition2);
        assertEquals(competition1, competition3);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getCompetitionName")
    @DisplayName("compare competitions with different ID")
    public void compareCompetitionsWithDifferentID(String secondCompetitionName) {
        Competition competition1 = new Competition(1, COMPETITION_NAME, SEASON);
        Competition competition2 = new Competition(2, secondCompetitionName, SEASON);
        Competition competition3 = new Competition(3, secondCompetitionName, null);

        log.info("compare competitions : ");
        log.info("competition 1 : {}", competition1);
        log.info("competition 2 : {}", competition2);
        log.info("competition 3 : {}", competition3);

        assertNotEquals(competition1, competition2);
        assertNotEquals(competition1, competition3);
    }
}