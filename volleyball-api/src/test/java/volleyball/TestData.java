package volleyball;

import org.springframework.data.util.Pair;
import volleyball.model.athlete.Gender;
import volleyball.tools.parser.ParserResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class TestData {

    // association test constants
    public static String ASSOCIATION_NAME = "association";

    // season test constants
    public static final int SEASON_START_YEAR = 2020;
    public static final int SEASON_END_YEAR = 2021;

    // competition test constants
    public static String COMPETITION_NAME = "competition";

    // result test constants
    public static final int RESULT_TEAM1_SETS = 3;
    public static final int RESULT_TEAM2_SETS = 2;

    // match test constants
    public static final LocalDateTime MATCH_DATE_TIME = LocalDateTime.of(2000, 1, 1, 12, 0);
    public static final String MATCH_NUMBER = "number";

    // club test constants
    public static String CLUB1_NAME = "club1";
    public static String CLUB2_NAME = "club2";

    // team test constants
    public static final String TEAM1_NAME = "team1";
    public static final String TEAM2_NAME = "team2";

    // member test constants
    public static final String ATHLETE_NAME = "name";
    public static final String ATHLETE_PRENAME = "preName";
    public static final LocalDate ATHLETE_BIRTHDAY = LocalDate.of(2000, 1, 1);
    public static final Gender ATHLETE_GENDER = Gender.MALE;

    // association test parameter
    public static Stream<String> getAssociationName() {
        return Stream.of(ASSOCIATION_NAME, "other-name", "");
    }

    // club test parameter
    public static Stream<String> getClubName() {
        return Stream.of(CLUB1_NAME, "other-name", "");
    }

    // team test parameter
    public static Stream<String> getTeamName() {
        return Stream.of(TEAM1_NAME, "other-name", "");
    }

    // competition test parameter
    public static Stream<String> getCompetitionName() {
        return Stream.of(COMPETITION_NAME, "other-name", "");
    }

    // season test parameter
    public static Stream<Pair<Integer, Integer>> getSeasonPeriod() {
        return Stream.of(
                Pair.of(SEASON_START_YEAR, SEASON_END_YEAR),
                Pair.of(SEASON_START_YEAR + 1, SEASON_END_YEAR),
                Pair.of(SEASON_START_YEAR, SEASON_END_YEAR + 1)
        );
    }

    // result test parameter
    public static Stream<Pair> getResultSet() {
        return Stream.of(
                Pair.of(RESULT_TEAM1_SETS, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS + 1, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, RESULT_TEAM2_SETS + 1)
        );
    }

    // match test parameter
    public static Stream<String> getMatchNumber() {
        return Stream.of(MATCH_NUMBER, "other-name", "");
    }

    // member test parameter
    public static Stream<String> getAthleteName() {
        return Stream.of(ATHLETE_NAME, "");
    }

    // factory test parameter
    public static Stream<ParserResult> getRequiredData() {
        return Stream.of(
                // without result
                ParserResult.builder()
                        .withAssociationName(TestData.ASSOCIATION_NAME)
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withSeasonEndYear(TestData.SEASON_END_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchNumber(TestData.MATCH_NUMBER)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withClub1Name(TestData.CLUB1_NAME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withClub2Name(TestData.CLUB2_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // without club1 name
                ParserResult.builder()
                        .withAssociationName(TestData.ASSOCIATION_NAME)
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withSeasonEndYear(TestData.SEASON_END_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchNumber(TestData.MATCH_NUMBER)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withClub2Name(TestData.CLUB2_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // without club2 name
                ParserResult.builder()
                        .withAssociationName(TestData.ASSOCIATION_NAME)
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withSeasonEndYear(TestData.SEASON_END_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchNumber(TestData.MATCH_NUMBER)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withClub2Name(TestData.CLUB2_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // without association name
                ParserResult.builder()
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withSeasonEndYear(TestData.SEASON_END_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchNumber(TestData.MATCH_NUMBER)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withClub1Name(TestData.CLUB1_NAME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withClub2Name(TestData.CLUB2_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // without season start year
                ParserResult.builder()
                        .withAssociationName(TestData.ASSOCIATION_NAME)
                        .withSeasonEndYear(TestData.SEASON_END_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchNumber(TestData.MATCH_NUMBER)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withClub1Name(TestData.CLUB1_NAME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withClub2Name(TestData.CLUB2_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // without season end year
                ParserResult.builder()
                        .withAssociationName(TestData.ASSOCIATION_NAME)
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchNumber(TestData.MATCH_NUMBER)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withClub1Name(TestData.CLUB1_NAME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withClub2Name(TestData.CLUB2_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // without competition name
                ParserResult.builder()
                        .withAssociationName(TestData.ASSOCIATION_NAME)
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withSeasonEndYear(TestData.SEASON_END_YEAR)
                        .withMatchNumber(TestData.MATCH_NUMBER)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withClub1Name(TestData.CLUB1_NAME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withClub2Name(TestData.CLUB2_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // without match number
                ParserResult.builder()
                        .withAssociationName(TestData.ASSOCIATION_NAME)
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withSeasonEndYear(TestData.SEASON_END_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withClub1Name(TestData.CLUB1_NAME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withClub2Name(TestData.CLUB2_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build()
        );
    }

    public static Stream<ParserResult> getInvalidSeasonData() {
        return Stream.of(
                // invalid season
                ParserResult.builder()
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withSeasonEndYear(TestData.SEASON_START_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // invalid season
                ParserResult.builder()
                        .withSeasonStartYear(1999)
                        .withSeasonEndYear(2000)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // invalid season
                ParserResult.builder()
                        .withSeasonStartYear(TestData.SEASON_START_YEAR)
                        .withSeasonEndYear(TestData.SEASON_START_YEAR + 2)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // invalid season
                ParserResult.builder()
                        .withSeasonStartYear(TestData.SEASON_END_YEAR)
                        .withSeasonEndYear(TestData.SEASON_START_YEAR)
                        .withCompetitionName(TestData.COMPETITION_NAME)
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build()
        );
    }

    public static Stream<ParserResult> getInvalidResultData() {
        return Stream.of(
                // invalid result
                ParserResult.builder()
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .withSetsTeam1(TestData.RESULT_TEAM1_SETS)
                        .withSetsTeam2(TestData.RESULT_TEAM1_SETS)
                        .build(),

                // invalid result
                ParserResult.builder()
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .withSetsTeam1(4)
                        .withSetsTeam2(TestData.RESULT_TEAM1_SETS)
                        .build(),

                // invalid result
                ParserResult.builder()
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .withSetsTeam1(TestData.RESULT_TEAM1_SETS)
                        .withSetsTeam2(4)
                        .build()
        );
    }

    public static Stream<ParserResult> getInvalidMatchData() {
        return Stream.of(
                // invalid match
                ParserResult.builder()
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),

                // invalid match
                ParserResult.builder()
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam2Name(TestData.TEAM2_NAME)
                        .build(),
                // invalid match

                ParserResult.builder()
                        .withMatchDateTime(TestData.MATCH_DATE_TIME)
                        .withTeam1Name(TestData.TEAM1_NAME)
                        .build());
    }
}
