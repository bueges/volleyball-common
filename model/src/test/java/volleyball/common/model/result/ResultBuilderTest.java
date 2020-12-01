package volleyball.common.model.result;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import volleyball.common.builder.BuilderException;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.*;

class ResultBuilderTest {

    private static final Logger logger = LogManager.getLogger(ResultBuilderTest.class);

    @Test
    @DisplayName("build result")
    public void buildResult() throws BuilderException {
        Result result = Result.builder()
                .withResult(RESULT_TEXT)
                .build();
        logger.info("build result : [{}]", result);

        assertNotNull(result);

        assertEquals(RESULT_TEAM1_SETS, result.getSetsTeam1());

        assertEquals(RESULT_TEAM2_SETS, result.getSetsTeam2());
    }

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getResultBuilderSets")
    @DisplayName("build result with invalid sets and check BuilderException")
    public void buildResultWithInvalidSets(String result) {
        assertThrows(BuilderException.class, () -> Result.builder()
                .withResult(result)
                .build());
    }
}