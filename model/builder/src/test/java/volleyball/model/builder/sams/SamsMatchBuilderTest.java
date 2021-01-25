package volleyball.model.builder.sams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.builder.match.Match;
import volleyball.model.builder.result.Result;
import volleyball.model.builder.team.Team;

import java.util.Optional;

import static volleyball.TestConstants.MATCH_DATE_TIME;
import static volleyball.TestConstants.MATCH_NUMBER;

class SamsMatchBuilderTest {

    // object under test
    private SamsMatchBuilder builder = new SamsMatchBuilder();

    @Test
    @DisplayName("build match object with valid data")
    public void testBuildMatchObjectWithValidData() {
        Optional<Match> match = builder
                .withDateTime(MATCH_DATE_TIME)
                .withNumber(MATCH_NUMBER)
                .withTeam1(Mockito.mock(Team.class))
                .withTeam2(Mockito.mock(Team.class))
                .withResult(Mockito.mock(Result.class))
                .build();

        Assertions.assertNotNull(match);
        Assertions.assertTrue(match.isPresent());
    }

    @Test
    @DisplayName("build match object without date time")
    public void testBuildMatchObjectWithoutDateTime() {
        Optional<Match> match = builder
                .withNumber(MATCH_NUMBER)
                .withTeam1(Mockito.mock(Team.class))
                .withTeam2(Mockito.mock(Team.class))
                .withResult(Mockito.mock(Result.class))
                .build();

        Assertions.assertNotNull(match);
        Assertions.assertFalse(match.isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getInvalidMatchNumber")
    @DisplayName("build match object without number")
    public void testBuildMatchObjectWithInvalidNumber(String number) {
        Optional<Match> match = builder
                .withNumber(number)
                .withDateTime(MATCH_DATE_TIME)
                .withTeam1(Mockito.mock(Team.class))
                .withTeam2(Mockito.mock(Team.class))
                .withResult(Mockito.mock(Result.class))
                .build();

        Assertions.assertNotNull(match);
        Assertions.assertFalse(match.isPresent());
    }

    @Test
    @DisplayName("build match object with empty number")
    public void testBuildMatchObjectWithNumber() {
        Optional<Match> match = builder
                .withDateTime(MATCH_DATE_TIME)
                .withTeam1(Mockito.mock(Team.class))
                .withTeam2(Mockito.mock(Team.class))
                .withNumber("")
                .withResult(Mockito.mock(Result.class))
                .build();

        Assertions.assertNotNull(match);
        Assertions.assertFalse(match.isPresent());
    }

    @Test
    @DisplayName("build match object without first team")
    public void testBuildMatchObjectWithoutFirstTeam() {
        Optional<Match> match = builder
                .withDateTime(MATCH_DATE_TIME)
                .withNumber(MATCH_NUMBER)
                .withTeam2(Mockito.mock(Team.class))
                .withResult(Mockito.mock(Result.class))
                .build();

        Assertions.assertNotNull(match);
        Assertions.assertFalse(match.isPresent());
    }

    @Test
    @DisplayName("build match object without second team")
    public void testBuildMatchObjectWithoutSecondTeam() {
        Optional<Match> match = builder
                .withDateTime(MATCH_DATE_TIME)
                .withNumber(MATCH_NUMBER)
                .withTeam1(Mockito.mock(Team.class))
                .withResult(Mockito.mock(Result.class))
                .build();

        Assertions.assertNotNull(match);
        Assertions.assertFalse(match.isPresent());
    }

    @Test
    @DisplayName("build match object without result")
    public void testBuildMatchObjectWithoutResult() {
        Optional<Match> match = builder
                .withDateTime(MATCH_DATE_TIME)
                .withNumber(MATCH_NUMBER)
                .withTeam1(Mockito.mock(Team.class))
                .withTeam2(Mockito.mock(Team.class))
                .build();

        Assertions.assertNotNull(match);
        Assertions.assertTrue(match.isPresent());
    }
}