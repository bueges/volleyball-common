package volleyball.model.builder;

import org.apache.commons.lang3.tuple.Pair;

import java.util.stream.Stream;

import static volleyball.TestConstants.RESULT_TEAM1_SETS;
import static volleyball.TestConstants.RESULT_TEAM2_SETS;

public class TestParameter {

    // association test parameter
    public static Stream<String> getInvalidAssociationName() {
        return Stream.of(null, "");
    }

    // season test parameter
    public static Stream<Pair<Integer, Integer>> getInvalidSeasonPeriod() {
        return Stream.of(
                Pair.of(RESULT_TEAM1_SETS, RESULT_TEAM1_SETS),
                Pair.of(4, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, 4),
                Pair.of(-1, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, -1)
        );
    }

    // competition test parameter
    public static Stream<String> getInvalidCompetitionName() {
        return Stream.of(null, "");
    }

    // result test parameter
    public static Stream<Pair<Integer, Integer>> getInvalidResultSet() {
        return Stream.of(
                Pair.of(RESULT_TEAM1_SETS, RESULT_TEAM1_SETS),
                Pair.of(4, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, 4),
                Pair.of(-1, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, -1));
    }

    // match test parameter
    public static Stream<String> getInvalidMatchNumber() {
        return Stream.of(null, "");
    }

    // club test parameter
    public static Stream<String> getInvalidClubName() {
        return Stream.of(null, "");
    }

    // team test parameter
    public static Stream<String> getInvalidTeamName() {
        return Stream.of(null, "");
    }

}
