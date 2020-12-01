package volleyball.common.model.result;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.RESULT_TEAM1_SETS;
import static volleyball.common.model.TestParameter.RESULT_TEAM2_SETS;

class ResultTest {

    private static final Logger logger = LogManager.getLogger(ResultTest.class);

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getResultSets")
    @DisplayName("create result")
    public void createResult(Pair<Integer, Integer> sets) {
        Result result = new Result(sets.getLeft(), sets.getRight());
        logger.info("create result : [{}]", result);

        assertNotNull(result);

        assertEquals(sets.getLeft().intValue(), result.getSetsTeam1());
        assertEquals(sets.getRight().intValue(), result.getSetsTeam2());
    }

    @Test
    @DisplayName("compare two equal results")
    public void compareTwoEqualResults() {
        Result result1 = new Result(RESULT_TEAM1_SETS, RESULT_TEAM2_SETS);
        Result result2 = new Result(RESULT_TEAM1_SETS, RESULT_TEAM2_SETS);

        logger.info("compare results : ");
        logger.info("result 1 : [{}]", result1);
        logger.info("result 2 : [{}]", result2);

        assertEquals(result1, result2);
    }

    @Test
    @DisplayName("compare two results with different team1 sets")
    public void compareTwoResultsWithDifferentTeam1Sets() {
        Result result1 = new Result(RESULT_TEAM1_SETS, RESULT_TEAM2_SETS);
        Result result2 = new Result(0, RESULT_TEAM2_SETS);

        logger.info("compare results : ");
        logger.info("result 1 : [{}]", result1);
        logger.info("result 2 : [{}]", result2);

        assertNotEquals(result1, result2);
    }

    @Test
    @DisplayName("compare two results with different team2 sets")
    public void compareTwoResultsWithDifferentTeam2Sets() {
        Result result1 = new Result(RESULT_TEAM1_SETS, RESULT_TEAM2_SETS);
        Result result2 = new Result(RESULT_TEAM1_SETS, 0);

        logger.info("compare results : ");
        logger.info("result 1 : [{}]", result1);
        logger.info("result 2 : [{}]", result2);

        assertNotEquals(result1, result2);
    }
}