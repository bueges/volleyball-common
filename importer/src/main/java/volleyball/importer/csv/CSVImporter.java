package volleyball.importer.csv;

import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import volleyball.model.factory.sams.SamsModelFactoryService;
import volleyball.importer.IImporter;
import volleyball.importer.importerData.IImportedData;
import volleyball.importer.importerData.ImportedData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static volleyball.importer.ImporterUtils.*;

public class CSVImporter implements IImporter {

    private static final Logger logger = LogManager.getLogger(CSVImporter.class);

    public static final int SEASON_PERIOD = 11;
    public static final int COMPETITION_NAME = 12;
    public static final int MATCH_NUMBER = 3;
    public static final int MATCH_DATE = 0;
    public static final int MATCH_TIME = 1;
    public static final int TEAM1_NAME = 5;
    public static final int TEAM2_NAME = 6;
    public static final int RESULT = 14;

    @Autowired
    SamsModelFactoryService modelFactoryService;

    @NonNull
    private final Path csvFilePath;
    private final String associationName;

    /**
     * @param csvFilePath     - the path to the csv file
     * @param associationName - the association name
     */
    public CSVImporter(Path csvFilePath, String associationName) {
        this.csvFilePath = csvFilePath;
        this.associationName = associationName;
    }

    @Override
    public List<IImportedData> importData() {
        logger.info("import csv file {}", csvFilePath.getFileName());
        List<IImportedData> importedDataList = Lists.newArrayList();

        try {
            ImportedData.ImportedDataBuilder builder = ImportedData.builder();
            List<String> csvLines = Lists.newArrayList();

            Files
                    .lines(csvFilePath, StandardCharsets.ISO_8859_1)
                    .skip(1) // skip headline
                    .collect(Collectors.toList())
                    .stream()
                    .forEach(line -> {
                        String[] csvFields = line.split("[,;]");

                        // set association fields
                        logger.debug("set builder field associationName : [{}]", associationName);
                        builder.withAssociationName(associationName);

                        // set season fields
                        int seasonStartYear = string2SeasonStartYear(getFieldValue(csvFields, SEASON_PERIOD));
                        logger.debug("set builder field seasonStartYear : [{}]", seasonStartYear);
                        builder.withSeasonStartYear(seasonStartYear);
                        int seasonEndYear = string2SeasonEndYear(getFieldValue(csvFields, SEASON_PERIOD));
                        logger.debug("set builder field seasonEndYear : [{}]", seasonEndYear);
                        builder.withSeasonEndYear(seasonEndYear);

                        // set competition fields
                        String competitionName = getFieldValue(csvFields, COMPETITION_NAME);
                        logger.debug("set builder field competitionName : [{}]", competitionName);
                        builder.withCompetitionName(competitionName);

                        // set match fields
                        LocalDate date = string2Date(getFieldValue(csvFields, MATCH_DATE));
                        LocalTime time = string2Time(getFieldValue(csvFields, MATCH_TIME));
                        LocalDateTime dateTime = LocalDateTime.of(date, time);
                        logger.debug("set builder field matchDateTime : [{}]", dateTime);
                        builder.withMatchDateTime(dateTime);

                        String matchNumber = getFieldValue(csvFields, MATCH_NUMBER);
                        logger.debug("set builder field matchNumber : [{}]", matchNumber);
                        builder.withMatchNumber(matchNumber);

                        // set team 1 fields
                        String team1Name = getFieldValue(csvFields, TEAM1_NAME);
                        logger.debug("set builder field team1Name : [{}]", team1Name);
                        builder.withTeam1Name(team1Name);
                        String club1Name = getClubNameFromTeamName(team1Name);
                        logger.debug("set builder field club1Name : [{}]", club1Name);
                        builder.withClub1Name(club1Name);

                        // set team 2 fields
                        String team2Name = getFieldValue(csvFields, TEAM2_NAME);
                        logger.debug("set builder field team2Name : [{}]", team2Name);
                        builder.withTeam2Name(team2Name);
                        String club2Name = getClubNameFromTeamName(team2Name);
                        logger.debug("set builder field club2Name : [{}]", club2Name);
                        builder.withClub2Name(club2Name);

                        // set result fields
                        String result = getFieldValue(csvFields, RESULT);
                        int setsTeam1 = string2ResultSetsTeam1(result);
                        logger.debug("set builder field setsTeam1 : [{}]", setsTeam1);
                        builder.withSetsTeam1(setsTeam1);

                        int setsTeam2 = string2ResultSetsTeam2(result);
                        logger.debug("set builder field setsTeam2 : [{}]", setsTeam2);
                        builder.withSetsTeam2(setsTeam2);

                        ImportedData importedData = builder.build();
                        logger.info("build imported data : {}", importedData);

                        importedDataList.add(importedData);
                    });

        } catch (IOException e) {
            logger.error("an IOException during parse csv file : {}", e.getMessage());
            e.printStackTrace();
        }

        return importedDataList;
    }

    /**
     * get the csv row field value
     *
     * @param csvFields  -  the csv row
     * @param fieldIndex - the csv field index
     * @return the field value or an empty string
     */
    private String getFieldValue(String[] csvFields, int fieldIndex) {
        String fieldValue = Strings.EMPTY;

        if (fieldIndex < csvFields.length - 1) {
            fieldValue = csvFields[fieldIndex].replace("\"", "");
        }

        return fieldValue;
    }
}