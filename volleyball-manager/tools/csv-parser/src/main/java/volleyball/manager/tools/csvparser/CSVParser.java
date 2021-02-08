package volleyball.manager.tools.csvparser;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import volleyball.tools.parser.IParser;
import volleyball.tools.parser.IParserResult;
import volleyball.tools.parser.ParserResult;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static volleyball.manager.tools.csvparser.ParserUtils.*;

@AllArgsConstructor
@Slf4j
public class CSVParser implements IParser {

    public static final int SEASON_PERIOD = 11;
    public static final int COMPETITION_NAME = 12;
    public static final int MATCH_NUMBER = 3;
    public static final int MATCH_DATE = 0;
    public static final int MATCH_TIME = 1;
    public static final int TEAM1_NAME = 5;
    public static final int TEAM2_NAME = 6;
    public static final int RESULT = 14;

    private final String associationName;
    private final Path inputFilePath;

    @Override
    public List<IParserResult> parseFile() {
        List<IParserResult> parserResultList = Lists.newArrayList();

        if (inputFilePath == null) {
            log.error("input file path is NULL - so return empty parser result");
        } else {
            try {
                Files.readAllLines(inputFilePath, Charset.forName("ISO-8859-1"))
                        .stream()
                        .skip(1) // skip headline
                        .collect(Collectors.toList())
                        .forEach(
                                line -> {
                                    ParserResult.ParserResultBuilder parserResult = ParserResult.builder();
                                    String[] csvFields = line.split("[,;]");

                                    // association fields
                                    log.debug("set parser field associationName : {}", associationName);
                                    parserResult.withAssociationName(associationName);

                                    // season fields
                                    String seasonPeriod = getFieldValue(csvFields, SEASON_PERIOD);
                                    int seasonStartYear = string2SeasonStartYear(seasonPeriod);
                                    log.debug("set parser field seasonStartYear : {}", seasonStartYear);
                                    parserResult.withSeasonStartYear(seasonStartYear);

                                    int seasonEndYear = string2SeasonEndYear(seasonPeriod);
                                    log.debug("set parser field seasonEndYear : {}", seasonEndYear);
                                    parserResult.withSeasonEndYear(seasonEndYear);

                                    // competition fields
                                    String competitionName = getFieldValue(csvFields, COMPETITION_NAME);
                                    log.debug("set parser field competitionName : {}", competitionName);
                                    parserResult.withCompetitionName(competitionName);

                                    // match fields
                                    LocalDate date = string2Date(getFieldValue(csvFields, MATCH_DATE));
                                    LocalTime time = string2Time(getFieldValue(csvFields, MATCH_TIME));
                                    LocalDateTime dateTime = LocalDateTime.of(date, time);
                                    log.debug("set parser field matchDateTime : {}", dateTime);
                                    parserResult.withMatchDateTime(dateTime);

                                    String matchNumber = getFieldValue(csvFields, MATCH_NUMBER);
                                    log.debug("set parser field matchNumber : {}", matchNumber);
                                    parserResult.withMatchNumber(matchNumber);

                                    // team 1 fields
                                    String team1Name = getFieldValue(csvFields, TEAM1_NAME);
                                    log.debug("set parser field team1Name : {}", team1Name);
                                    parserResult.withTeam1Name(team1Name);

                                    String club1Name = getClubNameFromTeamName(team1Name);
                                    log.debug("set parser field club1Name : {}", club1Name);
                                    parserResult.withClub1Name(club1Name);

                                    // team 2 fields
                                    String team2Name = getFieldValue(csvFields, TEAM2_NAME);
                                    log.debug("set parser field team2Name : {}", team2Name);
                                    parserResult.withTeam2Name(team2Name);

                                    String club2Name = getClubNameFromTeamName(team2Name);
                                    log.debug("set parser field club2Name : {}", club2Name);
                                    parserResult.withClub2Name(club2Name);

                                    // result fields
                                    String result = getFieldValue(csvFields, RESULT);
                                    int setsTeam1 = string2ResultSetsTeam1(result);
                                    log.debug("set parser field setsTeam1 : {}", setsTeam1);
                                    parserResult.withSetsTeam1(setsTeam1);

                                    int setsTeam2 = string2ResultSetsTeam2(result);
                                    log.debug("set parser field setsTeam2 : {}", setsTeam2);
                                    parserResult.withSetsTeam2(setsTeam2);

                                    IParserResult s = parserResult.build();
                                    log.info("parser data : {}", s);
                                    parserResultList.add(parserResult.build());
                                }
                        );
            } catch (IOException e) {
                log.error("an IOException occurred during parsing file : {}", inputFilePath, e);
                e.printStackTrace();
            }
        }

        return parserResultList;
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
