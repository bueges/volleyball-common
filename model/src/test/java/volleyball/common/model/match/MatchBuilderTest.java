package volleyball.common.model.match;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.common.builder.BuilderException;
import volleyball.common.model.result.Result;
import volleyball.common.model.team.Team;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.*;

class MatchBuilderTest {

    private static final Logger logger = LogManager.getLogger(MatchBuilderTest.class);

    // test parameter
    private final Team TEAM1 = Mockito.mock(Team.class);
    private final Team TEAM2 = Mockito.mock(Team.class);
    private final Result RESULT = Mockito.mock(Result.class);

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getMatchBuilderDateTime")
    @DisplayName("build match")
    public void buildMatch(String matchDateTime) throws BuilderException {
        Match match = Match.builder()
                .withDateTime(MATCH_DATE_TIME_TEXT)
                .withNumber(MATCH_NUMBER)
                .withTeam1(TEAM1)
                .withTeam2(TEAM2)
                .withResult(RESULT)
                .build();
        logger.info("build match : [{}]", match);

        assertNotNull(match);

        assertNotNull(match.getDateTime());
        assertEquals(MATCH_DATE_TIME, match.getDateTime());

        assertNotNull(match.getNumber());
        assertEquals(MATCH_NUMBER, match.getNumber());

        assertNotNull(match.getTeam1());

        assertNotNull(match.getTeam2());

        assertNotNull(match.getResult());
        assertTrue(match.getResult().isPresent());
    }

    @Test
    @DisplayName("build match with empty number")
    public void buildMatchWithEmptyNumber() throws BuilderException {
        Match match = Match.builder()
                .withDateTime(MATCH_DATE_TIME_TEXT)
                .withNumber("")
                .withTeam1(TEAM1)
                .withTeam2(TEAM2)
                .withResult(RESULT)
                .build();
        logger.info("build match : [{}]", match);

        assertNotNull(match);

        assertNotNull(match.getNumber());
        assertEquals("", match.getNumber());
    }

    @Test
    @DisplayName("build match without result")
    public void buildMatchWithoutResult() throws BuilderException {
        Match match = Match.builder()
                .withDateTime(MATCH_DATE_TIME_TEXT)
                .withNumber(MATCH_NUMBER)
                .withTeam1(TEAM1)
                .withTeam2(TEAM2)
                .build();
        logger.info("build match : [{}]", match);

        assertNotNull(match);

        assertNotNull(match.getResult());
        assertFalse(match.getResult().isPresent());
    }

    @Test
    @DisplayName("build match without date time and check BuilderException")
    public void buildMatchWithoutDateTime() {
        assertThrows(BuilderException.class, () -> Match.builder()
                .withNumber(MATCH_NUMBER)
                .withTeam1(TEAM1)
                .withTeam2(TEAM2)
                .build());
    }

    @Test
    @DisplayName("build match without number and check BuilderException")
    public void buildMatchWithoutNumber() {
        assertThrows(BuilderException.class, () -> Match.builder()
                .withDateTime(MATCH_DATE_TIME_TEXT)
                .withTeam1(TEAM1)
                .withTeam2(TEAM2)
                .build());
    }

    @Test
    @DisplayName("build match without team1 and check BuilderException")
    public void buildMatchWithoutTeam1() {
        assertThrows(BuilderException.class, () -> Match.builder()
                .withDateTime(MATCH_DATE_TIME_TEXT)
                .withNumber(MATCH_NUMBER)
                .withTeam1(null)
                .withTeam2(TEAM2)
                .build());
    }

    @Test
    @DisplayName("build match without team2 and check BuilderException")
    public void buildMatchWithoutTeam2() {
        assertThrows(BuilderException.class, () -> Match.builder()
                .withDateTime(MATCH_DATE_TIME_TEXT)
                .withNumber(MATCH_NUMBER)
                .withTeam1(TEAM1)
                .withTeam2(null)
                .build());
    }
}