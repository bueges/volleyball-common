package volleyball.model.result;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.data.util.Pair;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.RESULT_TEAM1_SETS;
import static volleyball.TestData.RESULT_TEAM2_SETS;

@Slf4j
class ResultTest {

    @Test
    @DisplayName("create result")
    public void createResult() {
        Result result = new Result(null, RESULT_TEAM1_SETS, RESULT_TEAM2_SETS);
        log.info("create result : {}", result);

        assertNotNull(result);

        assertEquals(RESULT_TEAM1_SETS, result.getSetsTeam1());
        assertEquals(RESULT_TEAM2_SETS, result.getSetsTeam2());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getResultSet")
    @DisplayName("compare results with same ID")
    public void compareAssociationsWithSameID(Pair<Integer, Integer> otherResultSet) {
        Result result1 = new Result(1, RESULT_TEAM1_SETS, RESULT_TEAM2_SETS);
        Result result2 = new Result(1, otherResultSet.getFirst(), otherResultSet.getSecond());

        log.info("compare results : ");
        log.info("result 1 : {}", result1);
        log.info("result 2 : {}", result2);

        assertEquals(result1, result2);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getResultSet")
    @DisplayName("compare results with different ID")
    public void compareAssociationsWithDifferentID(Pair<Integer, Integer> otherResultSet) {
        Result result1 = new Result(1, RESULT_TEAM1_SETS, RESULT_TEAM2_SETS);
        Result result2 = new Result(2, otherResultSet.getFirst(), otherResultSet.getSecond());

        log.info("compare results : ");
        log.info("result 1 : {}", result1);
        log.info("result 2 : {}", result2);

        assertNotEquals(result1, result2);
    }
}