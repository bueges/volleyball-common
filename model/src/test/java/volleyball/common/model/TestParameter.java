package volleyball.common.model;

import org.apache.commons.lang3.tuple.Pair;
import volleyball.common.model.member.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class TestParameter {

    // test parameter
    public static final String ASSOCIATION_NAME = "associationName";
    public static final String CLUB_NAME = "clubName";
    public static final int SEASON_PERIOD_START = 2020;
    public static final int SEASON_PERIOD_END = 2021;
    public static final String COMPETITION_NAME = "competitionName";
    public static final String TEAM_NAME = "teamName";
    public static final LocalDateTime MATCH_DATE_TIME = LocalDateTime.of(2000, 1, 1, 12, 0);
    public static final String MATCH_NUMBER = "number";
    public static final int RESULT_TEAM1_SETS = 3;
    public static final int RESULT_TEAM2_SETS = 2;
    public static final String MEMBER_NAME = "name";
    public static final String MEMBER_PRENAME = "preName";
    public static final LocalDate MEMBER_BIRTHDAY = LocalDate.of(2000, 1, 1);
    public static final Gender MEMBER_GENDER = Gender.MALE;

    // test builder parameter
    public static final String SEASON_PERIOD_TEXT = SEASON_PERIOD_START + "/" + SEASON_PERIOD_END;
    public static final String MATCH_DATE_TIME_TEXT = "01.01.2000 12:00";
    public static final String RESULT_TEXT = RESULT_TEAM1_SETS + ":" + RESULT_TEAM2_SETS;
    public static final String MEMBER_BIRTHDAY_TEXT = MEMBER_BIRTHDAY.toString();

    // = = = = = = TEAM = = = = = =
    // team test parameter
    public static Stream<String> getTeamName() {
        return Stream.of(TEAM_NAME, "");
    }

    // team builder test parameter
    public static Stream<String> getTeamBuilderName() {
        return Stream.of("", null);
    }

    // = = = = = = CLUB = = = = = =
    // club test parameter
    public static Stream<String> getClubName() {
        return Stream.of(CLUB_NAME, "");
    }

    // club builder test parameter
    public static Stream<String> getClubBuilderName() {
        return Stream.of("", null);
    }

    // = = = = = = ASSOCIATION = = = = = =
    // association test parameter
    public static Stream<String> getAssociationName() {
        return Stream.of(ASSOCIATION_NAME, "");
    }

    // association builder test parameter
    public static Stream<String> getAssociationBuilderName() {
        return Stream.of("", null);
    }

    // = = = = = = SEASON = = = = = =
    // season test parameter
    public static Stream<Pair> getSeasonPeriod() {
        return Stream.of(Pair.of(SEASON_PERIOD_START, SEASON_PERIOD_END),
                Pair.of(SEASON_PERIOD_START - 1, SEASON_PERIOD_END + 1),
                Pair.of(SEASON_PERIOD_START, SEASON_PERIOD_START),
                Pair.of(SEASON_PERIOD_END, SEASON_PERIOD_START));
    }

    // season builder test parameter
    public static Stream<String> getSeasonBuilderPeriod() {
        return Stream.of(SEASON_PERIOD_START - 1 + "/" + SEASON_PERIOD_END + 1,
                SEASON_PERIOD_START + "/" + SEASON_PERIOD_START,
                SEASON_PERIOD_END + "/" + SEASON_PERIOD_START,
                SEASON_PERIOD_START + "-" + SEASON_PERIOD_END);
    }

    // = = = = = = COMPETITION = = = = = =
    // competition test parameter
    public static Stream<String> getCompetitionName() {
        return Stream.of(COMPETITION_NAME, "");
    }

    // competition builder test parameter
    public static Stream<String> getCompetitionBuilderName() {
        return Stream.of("", null);
    }

    // = = = = = = RESULT = = = = = =
    // result test parameter
    public static Stream<Pair> getResultSets() {
        return Stream.of(Pair.of(RESULT_TEAM1_SETS, RESULT_TEAM2_SETS),
                Pair.of(-1, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS + 1, RESULT_TEAM2_SETS),
                Pair.of(RESULT_TEAM1_SETS, -1),
                Pair.of(RESULT_TEAM1_SETS, RESULT_TEAM1_SETS));
    }

    // result builder test parameter
    public static Stream<String> getResultBuilderSets() {
        return Stream.of("-1:" + RESULT_TEAM2_SETS,
                "4:" + RESULT_TEAM2_SETS,
                RESULT_TEAM1_SETS + ":-1",
                RESULT_TEAM1_SETS + ":4",
                RESULT_TEAM1_SETS + ":" + RESULT_TEAM1_SETS,
                "a:" + RESULT_TEAM2_SETS,
                RESULT_TEAM1_SETS + ":a");
    }

    // = = = = = = MATCH = = = = = =
    public static Stream<String> getMatchBuilderDateTime() {
        return Stream.of("01.01.2000 12:00",
                "1.01.2000 12:00",
                "01.1.2000 12:00",
                "1.1.2000 12:00",
                "01.01.00 12:00",
                "1.01.00 12:00",
                "01.1.00 12:00");
    }

    // = = = = = = MEMBER = = = = = =
    public static Stream<Pair> getMemberData() {
        return Stream.of(
                Pair.of(MEMBER_NAME, MEMBER_PRENAME),
                Pair.of("", MEMBER_PRENAME),
                Pair.of(MEMBER_NAME, ""));
    }

    public static Stream<Pair> getMemberBuilderData() {
        return Stream.of(
                Pair.of("", MEMBER_PRENAME),
                Pair.of(null, MEMBER_PRENAME),
                Pair.of(MEMBER_NAME, null));
    }

    public static Stream<String> getMemberBuilderBirthday() {
        return Stream.of("01.01.2000",
                "1.01.2000",
                "01.1.2000",
                "1.1.2000",
                "01.01.00",
                "1.01.00",
                "01.1.00");
    }
}
