package volleyball.common.model.match;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import volleyball.common.model.result.Result;
import volleyball.common.model.team.Team;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.MATCH_DATE_TIME;
import static volleyball.common.model.TestParameter.MATCH_NUMBER;

class MatchTest {

    private static final Logger logger = LogManager.getLogger(MatchTest.class);

    // test parameter
    private final Team TEAM1 = Mockito.mock(Team.class);
    private final Team TEAM2 = Mockito.mock(Team.class);
    private final Result RESULT = Mockito.mock(Result.class);

    @Test
    @DisplayName("create match")
    public void createMatch() {
        Match match = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, RESULT);
        logger.info("create match : [{}]", match);

        assertNotNull(match);

        assertNotNull(match.getDateTime());
        assertEquals(MATCH_DATE_TIME, match.getDateTime());

        assertNotNull(match.getNumber());
        assertEquals(MATCH_NUMBER, match.getNumber());

        assertNotNull(match.getTeam1());
        assertEquals(TEAM1, match.getTeam1());

        assertNotNull(match.getTeam2());
        assertEquals(TEAM2, match.getTeam2());

        assertNotNull(match.getResult());
        assertTrue(match.getResult().isPresent());
    }

    @Test
    @DisplayName("create match without result")
    public void createMatchWithoutResult() {
        Match match = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, null);
        logger.info("create match : [{}]", match);

        assertNotNull(match.getResult());
        assertFalse(match.getResult().isPresent());
    }

    @Test
    @DisplayName("create match with null date time and check NULLPointerException")
    public void createMatchWithNullDateTime() {
        assertThrows(NullPointerException.class, () -> new Match(null, MATCH_NUMBER, TEAM1, TEAM2, RESULT));
    }

    @Test
    @DisplayName("create match with null number and check NULLPointerException")
    public void createMatchWithNullNumber() {
        assertThrows(NullPointerException.class, () -> new Match(MATCH_DATE_TIME, null, TEAM1, TEAM2, RESULT));
    }

    @Test
    @DisplayName("create match with null team1 and check NULLPointerException")
    public void createMatchWithNullTeam1() {
        assertThrows(NullPointerException.class, () -> new Match(MATCH_DATE_TIME, MATCH_NUMBER, null, TEAM2, RESULT));
    }

    @Test
    @DisplayName("create match with null team2 and check NULLPointerException")
    public void createMatchWithNullTeam2() {
        assertThrows(NullPointerException.class, () -> new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, null, RESULT));
    }

    @Test
    @DisplayName("compare two equal matches")
    public void compareTwoEqualMatches() {
        Match match1 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : [{}]", match1);
        logger.info("match1 2 : [{}]", match2);

        assertEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different date time")
    public void compareTwoMatchesWithDifferentDateTime() {
        Match match1 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, RESULT);
        Match match2 = new Match(LocalDateTime.of(2010, 1, 1, 12, 0), MATCH_NUMBER, TEAM1, TEAM2, RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : [{}]", match1);
        logger.info("match1 2 : [{}]", match2);

        assertNotEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different number")
    public void compareTwoMatchesWithDifferentNumber() {
        Match match1 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, "other-number", TEAM1, TEAM2, RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : [{}]", match1);
        logger.info("match1 2 : [{}]", match2);

        assertNotEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different team1")
    public void compareTwoMatchesWithDifferentTeam1() {
        Match match1 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, Mockito.mock(Team.class), TEAM2, RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : [{}]", match1);
        logger.info("match1 2 : [{}]", match2);

        assertNotEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different team2")
    public void compareTwoMatchesWithDifferentTeam2() {
        Match match1 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, Mockito.mock(Team.class), RESULT);

        logger.info("compare matches : ");
        logger.info("match1 1 : [{}]", match1);
        logger.info("match1 2 : [{}]", match2);

        assertNotEquals(match1, match2);
    }

    @Test
    @DisplayName("compare two matches with different result")
    public void compareTwoMatchesWithDifferentResult() {
        Match match1 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, RESULT);
        Match match2 = new Match(MATCH_DATE_TIME, MATCH_NUMBER, TEAM1, TEAM2, Mockito.mock(Result.class));

        logger.info("compare matches : ");
        logger.info("match1 1 : [{}]", match1);
        logger.info("match1 2 : [{}]", match2);

        assertNotEquals(match1, match2);
    }
}