package volleyball;

import volleyball.tools.parser.ParserResult;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class TestParameter {

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

    // factory test parameter
    public static Stream<ParserResult> getValidMatchData() {
        return Stream.of(
                // with result
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without result
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build()
        );
    }

    public static Stream<ParserResult> getInvalidMatchData() {
        return Stream.of(
                // without association name
                ParserResult.builder()
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .build(),

                // without season start year
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without season end year
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without competition name
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without match number
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without match date tim
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without first club name
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without first team name
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without second club name
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without second team name
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build()
        );
    }

    public static Stream<ParserResult> getInvalidResultData() {
        return Stream.of(
                // without sets first team
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .build(),

                // without sets second team
                ParserResult.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .build()
        );
    }
}
