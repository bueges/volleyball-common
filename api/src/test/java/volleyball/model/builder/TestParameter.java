package volleyball.model.builder;

import org.apache.commons.lang3.tuple.Pair;

import java.util.stream.Stream;

import static volleyball.TestConstants.*;


public class TestParameter {

    // association test parameter
    public static Stream<String> getAssociationName() {
        return Stream.of(ASSOCIATION_NAME, "");
    }

    // season test parameter
    public static Stream<Pair<Integer, Integer>> getSeasonPeriod() {
        return Stream.of(
                Pair.of(SEASON_START_YEAR, SEASON_END_YEAR),
                Pair.of(SEASON_START_YEAR, SEASON_START_YEAR),
                Pair.of(SEASON_START_YEAR, SEASON_END_YEAR + 1),
                Pair.of(-1, SEASON_END_YEAR),
                Pair.of(SEASON_START_YEAR, -1),
                Pair.of(SEASON_END_YEAR, SEASON_START_YEAR)
        );
    }

    // competition test parameter
    public static Stream<String> getCompetitionName() {
        return Stream.of(COMPETITION_NAME, "");
    }

    // result test parameter
    public static Stream<Pair> getResultSets() {
        return Stream.of(
                Pair.of(RESULT_TEAM1_SETS, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, RESULT_TEAM1_SETS),
                Pair.of(4, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, 4),
                Pair.of(-1, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, -1)
        );
    }

    // match test parameter
    public static Stream<String> getMatchNumber() {
        return Stream.of(MATCH_NUMBER, "");
    }

    // club test parameter
    public static Stream<String> getClubName() {
        return Stream.of(CLUB1_NAME, "");
    }

    // team test parameter
    public static Stream<String> getTeamName() {
        return Stream.of(TEAM1_NAME, "");
    }

    // member test parameter
    public static Stream<String> getMemberName() {
        return Stream.of(MEMBER_NAME, "");
    }

    public static Stream<String> getMemberPreName() {
        return Stream.of(MEMBER_PRENAME, "");
    }
}
