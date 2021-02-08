package volleyball.model.match;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.result.Result;
import volleyball.model.team.Team;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.MATCH_DATE_TIME;
import static volleyball.TestData.MATCH_NUMBER;

@Slf4j
class MatchTest {

    // test parameter
    private final Team TEAM1 = Mockito.mock(Team.class);
    private final Team TEAM2 = Mockito.mock(Team.class);
    private final Result RESULT = Mockito.mock(Result.class);

    @Test
    @DisplayName("create match with valid number")
    public void createMatch() {
        Match match = new Match(null, MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        log.info("create match : {}", match);

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
    @DisplayName("check NullPointerException when create match with null date time")
    public void testCheckNullPointerExceptionWhenCreateMatchWithNULLDateTime() {
        assertThrows(NullPointerException.class, () -> new Match(null, null, TEAM1, TEAM2, MATCH_NUMBER, RESULT));
    }

    @Test
    @DisplayName("check NullPointerException when create match with null first team")
    public void testCheckNullPointerExceptionWhenCreateMatchWithNULLTeam1() {
        assertThrows(NullPointerException.class, () -> new Match(null, MATCH_DATE_TIME, null, TEAM2, MATCH_NUMBER, RESULT));
    }

    @Test
    @DisplayName("check NullPointerException when create match with null second team")
    public void testCheckNullPointerExceptionWhenCreateMatchWithNULLTeam2() {
        assertThrows(NullPointerException.class, () -> new Match(null, MATCH_DATE_TIME, TEAM1, null, MATCH_NUMBER, RESULT));
    }

    @Test
    @DisplayName("create match without number")
    public void testCheckNullPointerExceptionWhenCreateMatchWithNULLNumber() {
        Match match = new Match(null, MATCH_DATE_TIME, TEAM1, TEAM2, null, RESULT);
        log.info("create match : {}", match);
    }

    @Test
    @DisplayName("create match without result object")
    public void createMatchWithoutResultObject() {
        Match match = new Match(null, MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, null);
        log.info("create match : {}", match);

        assertNotNull(match.getResult());
        assertFalse(match.getResult().isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getMatchNumber")
    @DisplayName("compare matches with same ID")
    public void compareMatchesWithSameID(String otherMatchNumber) {
        Match match1 = new Match(1, MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        Match match2 = new Match(1, MATCH_DATE_TIME, TEAM1, TEAM2, otherMatchNumber, RESULT);
        Match match3 = new Match(1, LocalDateTime.of(2010, 1, 1, 12, 0), TEAM1, TEAM2, otherMatchNumber, RESULT);
        Match match4 = new Match(1, MATCH_DATE_TIME, Mockito.mock(Team.class), TEAM2, otherMatchNumber, RESULT);
        Match match5 = new Match(1, MATCH_DATE_TIME, TEAM1, Mockito.mock(Team.class), otherMatchNumber, RESULT);
        Match match6 = new Match(1, MATCH_DATE_TIME, TEAM1, TEAM2, otherMatchNumber, Mockito.mock(Result.class));

        log.info("compare matches : ");
        log.info("match 1 : {}", match1);
        log.info("match 2 : {}", match2);
        log.info("match 2 : {}", match3);
        log.info("match 2 : {}", match4);
        log.info("match 2 : {}", match5);
        log.info("match 2 : {}", match6);

        assertEquals(match1, match2);
        assertEquals(match1, match3);
        assertEquals(match1, match4);
        assertEquals(match1, match5);
        assertEquals(match1, match6);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getMatchNumber")
    @DisplayName("compare matches with different ID")
    public void compareMatchesWithDifferentID(String otherMatchNumber) {
        Match match1 = new Match(1, MATCH_DATE_TIME, TEAM1, TEAM2, MATCH_NUMBER, RESULT);
        Match match2 = new Match(2, MATCH_DATE_TIME, TEAM1, TEAM2, otherMatchNumber, RESULT);
        Match match3 = new Match(3, LocalDateTime.of(2010, 1, 1, 12, 0), TEAM1, TEAM2, otherMatchNumber, RESULT);
        Match match4 = new Match(4, MATCH_DATE_TIME, Mockito.mock(Team.class), TEAM2, otherMatchNumber, RESULT);
        Match match5 = new Match(5, MATCH_DATE_TIME, TEAM1, Mockito.mock(Team.class), otherMatchNumber, RESULT);
        Match match6 = new Match(6, MATCH_DATE_TIME, TEAM1, TEAM2, otherMatchNumber, Mockito.mock(Result.class));

        log.info("compare matches : ");
        log.info("match 1 : {}", match1);
        log.info("match 2 : {}", match2);
        log.info("match 2 : {}", match3);
        log.info("match 2 : {}", match4);
        log.info("match 2 : {}", match5);
        log.info("match 2 : {}", match6);

        assertNotEquals(match1, match2);
        assertNotEquals(match1, match3);
        assertNotEquals(match1, match4);
        assertNotEquals(match1, match5);
        assertNotEquals(match1, match6);
    }
}