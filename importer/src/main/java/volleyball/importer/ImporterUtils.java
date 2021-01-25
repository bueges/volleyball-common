package volleyball.importer;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.util.Lists;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImporterUtils {

    private static final Logger logger = LogManager.getLogger(ImporterUtils.class);

    /**
     * convert the a text to an {@link LocalDate} object
     *
     * @param dateText - the date text to convert
     * @return the converted {@link LocalDate} object or if an error occurred NULL
     */
    public static LocalDate string2Date(String dateText) {
        List<String> datePattern = Lists.newArrayList("dd.MM.yyyy", "d.MM.yyyy", "dd.M.yyyy", "d.M.yyyy", "d.M.yy");
        LocalDate date = null;

        for (String pattern : datePattern) {
            try {
                date = LocalDate.parse(dateText, DateTimeFormatter.ofPattern(pattern, Locale.GERMAN));
                break;
            } catch (DateTimeParseException e) {
                logger.warn(e.getMessage());
            }
        }

        return date;
    }

    /**
     * convert a text to {@link LocalTime} object
     *
     * @param timeText - the time text to convert
     * @return the converted {@link LocalTime} object or if an error occurred NULL
     */
    public static LocalTime string2Time(String timeText) {
        List<String> timePattern = Lists.newArrayList("HH:mm", "HH:mm:ss");
        LocalTime time = null;

        for (String pattern : timePattern) {
            try {
                time = LocalTime.parse(timeText, DateTimeFormatter.ofPattern(pattern, Locale.GERMAN));
                break;
            } catch (DateTimeParseException e) {
                logger.warn(e.getMessage());
            }
        }

        return time;
    }

    /**
     * convert a text to a season period - start and end year
     *
     * @param periodText - the period to convert
     * @return the period array or if an error occurred 0 array
     */
    protected static int[] string2SeasonPeriod(String periodText) {
        String[] period = periodText.split("/");
        int seasonStartYear = 0;
        int seasonEndYear = 0;

        if (period != null && period.length == 2) {

            try {
                seasonStartYear = Integer.valueOf(period[0]);
                seasonEndYear = Integer.valueOf(period[1]);
                int difference = seasonEndYear % 100 - seasonStartYear % 100;
                seasonEndYear = seasonStartYear + difference;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                logger.error("a NumberFormatException occurred : {}", e.getMessage());
            }
        }

        return new int[]{seasonStartYear, seasonEndYear};
    }

    /**
     * convert a text to a season start year
     *
     * @param periodText - the period to convert
     * @return the season start year or if an error occurred 0
     */
    public static int string2SeasonStartYear(String periodText) {
        return string2SeasonPeriod(periodText)[0];
    }

    /**
     * convert a text to a season end year
     *
     * @param periodText - the period to convert
     * @return the season end year or if an error occurred 0
     */
    public static int string2SeasonEndYear(String periodText) {
        return string2SeasonPeriod(periodText)[1];
    }

    /**
     * convert a text to a result - sets team1 and sets team2
     *
     * @param resultText - the result text to convert
     * @ return the result array or if an error occurred 0 array
     */
    protected static int[] string2Result(String resultText) {
        String[] result = resultText.split(":");
        int setsTeam1 = 0;
        int setsTeam2 = 0;

        if (result != null && result.length == 2) {

            try {
                setsTeam1 = Integer.valueOf(result[0]);
                setsTeam2 = Integer.valueOf(result[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                logger.error("a NumberFormatException occurred : {}", e.getMessage());
            }
        }

        return new int[]{setsTeam1, setsTeam2};
    }

    /**
     * convert a text to a result sets team1
     *
     * @param resultText - the result text to convert
     * @return the result sets team 1 or if an error occurred 0
     */
    public static int string2ResultSetsTeam1(String resultText) {
        return string2Result(resultText)[0];
    }

    /**
     * convert a text to a result sets team2
     *
     * @param resultText - the result text to convert
     * @return the result sets team 1 or if an error occurred 0
     */
    public static int string2ResultSetsTeam2(String resultText) {
        return string2Result(resultText)[1];
    }

    public static String getClubNameFromTeamName(String teamName) {
        String clubName = teamName;
        Pattern pattern = Pattern.compile("\\s(\\d{1,2})$");
        Matcher matcher = pattern.matcher(teamName);

        if (matcher.find()){
            clubName = StringUtils.removeEnd(teamName, matcher.group(0));
        }

        return clubName;

    }
}
