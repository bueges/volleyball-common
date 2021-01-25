package volleyball.model.factory;

import volleyball.importer.importerData.ImportedData;

import java.util.stream.Stream;

import static volleyball.TestConstants.*;

public class TestParameter {

    // complete imported data
    public static Stream<ImportedData> getCompleteImportedData() {

        return Stream.of(ImportedData.builder()
                .withAssociationName(ASSOCIATION_NAME)
                .withSeasonStartYear(SEASON_START_YEAR)
                .withSeasonEndYear(SEASON_END_YEAR)
                .withCompetitionName(COMPETITION_NAME)
                .withMatchDateTime(MATCH_DATE_TIME)
                .withMatchNumber(MATCH_NUMBER)
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .withClub1Name(CLUB1_NAME)
                .withTeam1Name(TEAM1_NAME)
                .withClub2Name(CLUB2_NAME)
                .withTeam2Name(TEAM2_NAME)
                .build()
        );
    }

    // imported data without association name
    public static Stream<ImportedData> getImportedDataWithoutAssociationName() {
        return Stream.of(ImportedData.builder()
                .withSeasonStartYear(SEASON_START_YEAR)
                .withSeasonEndYear(SEASON_END_YEAR)
                .withCompetitionName(COMPETITION_NAME)
                .withMatchDateTime(MATCH_DATE_TIME)
                .withMatchNumber(MATCH_NUMBER)
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .withClub1Name(CLUB1_NAME)
                .withTeam1Name(TEAM1_NAME)
                .withClub2Name(CLUB2_NAME)
                .withTeam2Name(TEAM2_NAME)
                .build()
        );
    }

    // imported data without season start year
    public static Stream<ImportedData> getImportedDataWithoutSeasonStartYear() {
        return Stream.of(
                ImportedData.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .build());
    }

    // imported data without season end year
    public static Stream<ImportedData> getImportedDataWithoutSeasonEndYear() {
        return Stream.of(
                ImportedData.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .build());
    }

    // imported data without competition name
    public static Stream<ImportedData> getImportedDataWithoutCompetitionName() {
        return Stream.of(ImportedData.builder()
                .withAssociationName(ASSOCIATION_NAME)
                .withSeasonStartYear(SEASON_START_YEAR)
                .withSeasonEndYear(SEASON_END_YEAR)
                .withMatchDateTime(MATCH_DATE_TIME)
                .withMatchNumber(MATCH_NUMBER)
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .withClub1Name(CLUB1_NAME)
                .withTeam1Name(TEAM1_NAME)
                .withClub2Name(CLUB2_NAME)
                .withTeam2Name(TEAM2_NAME)
                .build()
        );
    }

    // imported data without result sets team1
    public static Stream<ImportedData> getImportedDataWithoutResultSetsTeam1() {
        return Stream.of(ImportedData.builder()
                .withAssociationName(ASSOCIATION_NAME)
                .withSeasonStartYear(SEASON_START_YEAR)
                .withSeasonEndYear(SEASON_END_YEAR)
                .withCompetitionName(COMPETITION_NAME)
                .withMatchDateTime(MATCH_DATE_TIME)
                .withMatchNumber(MATCH_NUMBER)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .withClub1Name(CLUB1_NAME)
                .withTeam1Name(TEAM1_NAME)
                .withClub2Name(CLUB2_NAME)
                .withTeam2Name(TEAM2_NAME)
                .build());
    }


    // imported data without result sets team2
    public static Stream<ImportedData> getImportedDataWithoutResultSetsTeam2() {
        return Stream.of(ImportedData.builder()
                .withAssociationName(ASSOCIATION_NAME)
                .withSeasonStartYear(SEASON_START_YEAR)
                .withSeasonEndYear(SEASON_END_YEAR)
                .withCompetitionName(COMPETITION_NAME)
                .withMatchDateTime(MATCH_DATE_TIME)
                .withMatchNumber(MATCH_NUMBER)
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withClub1Name(CLUB1_NAME)
                .withTeam1Name(TEAM1_NAME)
                .withClub2Name(CLUB2_NAME)
                .withTeam2Name(TEAM2_NAME)
                .build());
    }

    // imported data without match data
    public static Stream<ImportedData> getImportedDataWithoutMatchDateTime() {
        return Stream.of(
                ImportedData.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchNumber(MATCH_NUMBER)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .build());
    }

    public static Stream<ImportedData> getImportedDataWithoutMatchNumber() {
        return Stream.of(
                ImportedData.builder()
                        .withAssociationName(ASSOCIATION_NAME)
                        .withSeasonStartYear(SEASON_START_YEAR)
                        .withSeasonEndYear(SEASON_END_YEAR)
                        .withCompetitionName(COMPETITION_NAME)
                        .withMatchDateTime(MATCH_DATE_TIME)
                        .withSetsTeam1(RESULT_TEAM1_SETS)
                        .withSetsTeam2(RESULT_TEAM2_SETS)
                        .withClub1Name(CLUB1_NAME)
                        .withTeam1Name(TEAM1_NAME)
                        .withClub2Name(CLUB2_NAME)
                        .withTeam2Name(TEAM2_NAME)
                        .build());
    }

    // imported data without club data
    public static Stream<ImportedData> getImportedDataWithoutClubName() {
        return Stream.of(ImportedData.builder()
                .withAssociationName(ASSOCIATION_NAME)
                .withSeasonStartYear(SEASON_START_YEAR)
                .withSeasonEndYear(SEASON_END_YEAR)
                .withCompetitionName(COMPETITION_NAME)
                .withMatchDateTime(MATCH_DATE_TIME)
                .withMatchNumber(MATCH_NUMBER)
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .withTeam1Name(TEAM1_NAME)
                .withTeam2Name(TEAM2_NAME)
                .build()
        );
    }

    // imported data without team data
    public static Stream<ImportedData> getImportedDataWithoutTeamData() {
        return Stream.of(ImportedData.builder()
                .withAssociationName(ASSOCIATION_NAME)
                .withSeasonStartYear(SEASON_START_YEAR)
                .withSeasonEndYear(SEASON_END_YEAR)
                .withCompetitionName(COMPETITION_NAME)
                .withMatchDateTime(MATCH_DATE_TIME)
                .withMatchNumber(MATCH_NUMBER)
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .withClub1Name(CLUB1_NAME)
                .withClub2Name(CLUB2_NAME)
                .build()
        );
    }
}
