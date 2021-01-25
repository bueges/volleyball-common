package volleyball.model.builder.match;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.builder.result.Result;
import volleyball.model.builder.team.Team;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestConstants.MATCH_DATE_TIME;
import static volleyball.TestConstants.MATCH_NUMBER;

class MatchTest {

    private static final Logger logger = LogManager.getLogger(MatchTest.class);

    // test parameter
    private final Team TEAM1 = Mockito.mock(Team.class);
    private final Team TEAM2 = Mockito.mock(Team.class);
    private final Result RESULT = Mockito.mock(Result.class);

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getMatchNumber")
    @DisplayName("create match with valid number")
    public void createMatch(String number) {
        Match match = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, number, RESULT);
        logger.info("create match : {}", match);

        assertNotNull(match);

        assertNotNull(match.getDateTime());
        assertEquals(MATCH_DATE_TIME, match.getDateTime());

        assertNotNull(match.getNumber());
        assertEquals(number, match.getNumber());

        assertNotNull(match.getTeam1());
        assertEquals(TEAM1, match.getTeam1());

        assertNotNull(match.getTeam2());
        assertEquals(TEAM2, match.getTeam2());

        assertNotNull(match.getResult());
        assertTrue(match.getResult().isPresent());
    }

    @Test
    @DisplayName("check NullPointerException when create match with null date time")
    public void testCheckNullPointerExceptionWhenCreateMatchWithNULLDateTime() {
        assertThrows(NullPointerException.class, () -> new Match(null, TEAM1, TEAM2, MATCH_NUMBER, RESULT));
    }

    @Test
    @DisplayName("check NullPointerException when create match with null first team")
    public void testCheckNullPointerExceptionWhenCreateMatchWithNULLTeam1() {
        assertThrows(NullPointerException.class, () -> new Match(MATCH_DATE_TIME, null, TEAM2, MATCH_NUMBER, RESULT));
    }

    @Test
    @DisplayName("check NullPointerException when create match with null second team")
    public void testCheckNullPointerExceptionWhenCreateMatchWithNULLTeam2() {
        assertThrows(NullPointerException.class, () -> new Match(MATCH_DATE_TIME, TEAM1, null, MATCH_NUMBER, RESULT));
    }

    @Test
    @DisplayName("create match without number")
    public void testCheckNullPointerExceptionWhenCreateMatchWithNULLNumber() {
        Match match = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, null, RESULT);
        logger.info("create match : {}", match);
    }

    @Test
    @DisplayName("create match without result object")
    public void createMatchWithoutResultObject() {
        Match match = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, null);
        logger.info("create match : {}", match);

        assertNotNull(match.getResult());
        assertFalse(match.getResult().isPresent());
    }

    @Test
    @DisplayName("compare two equal matches")
    public void compareTwoEqualMatches() {
        Match match1 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : {}", match1);
        logger.info("match1 2 : {}", match2);

        assertEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different date time")
    public void compareTwoMatchesWithDifferentDateTime() {
        Match match1 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        Match match2 = new Match(LocalDateTime.of(2010, 1, 1, 12, 0), TEAM1, TEAM2, MATCH_NUMBER, RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : {}", match1);
        logger.info("match1 2 : {}", match2);

        assertNotEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different number")
    public void compareTwoMatchesWithDifferentNumber() {
        Match match1 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, "other-number", RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : {}", match1);
        logger.info("match1 2 : {}", match2);

        assertNotEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different team1")
    public void compareTwoMatchesWithDifferentTeam1() {
        Match match1 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, Mockito.mock(Team.class), TEAM2, MATCH_NUMBER, RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : {}", match1);
        logger.info("match1 2 : {}", match2);

        assertNotEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different team2")
    public void compareTwoMatchesWithDifferentTeam2() {
        Match match1 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, TEAM1, Mockito.mock(Team.class), MATCH_NUMBER, RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : {}", match1);
        logger.info("match1 2 : {}", match2);

        assertNotEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different result")
    public void compareTwoMatchesWithDifferentResult() {
        Match match1 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, Mockito.mock(Result.class));

        logger.info("compare matches : ");
        logger.info("match1 1 : {}", match1);
        logger.info("match1 2 : {}", match2);

        assertNotEquals(match1, match2);
    }
}