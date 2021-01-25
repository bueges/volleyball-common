package volleyball.model.builder.sams;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import volleyball.model.builder.result.Result;

import java.util.Optional;

import static volleyball.TestConstants.RESULT_TEAM1_SETS;
import static volleyball.TestConstants.RESULT_TEAM2_SETS;

class SamsResultBuilderTest {

    // object under test
    private SamsResultBuilder builder = new SamsResultBuilder();

    @Test
    @DisplayName("build empty result object with valid data")
    public void testBuildEmptyResultObjectWithValidData() {
        Optional<Result> result = builder
                .withSetsTeam1(0)
                .withSetsTeam2(0)

                .build();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("build result object with valid data")
    public void testBuildResultObjectWithValidData() {
        Optional<Result> result = builder
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)

                .build();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getInvalidResultSet")
    @DisplayName("build result object with invalid result set")
    public void testBuildResultObjectWithInvalidResultSet(Pair<Integer, Integer> resultSet) {
        Optional<Result> result = builder
                .withSetsTeam1(resultSet.getLeft())
                .withSetsTeam2(resultSet.getRight())

                .build();

        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isPresent());
    }
}