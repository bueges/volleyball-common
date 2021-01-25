package volleyball.importer;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalTime;

public class ImporterUtilsTest {

    @ParameterizedTest
    @MethodSource("volleyball.importer.TestParameter#getTimeString")
    @DisplayName("convert a text to a time object")
    public void testConvertText2Time(String timeString) {
        LocalTime time = ImporterUtils.string2Time(timeString);

        Assert.assertEquals(14, time.getHour());
        Assert.assertEquals(30, time.getMinute());
    }

    @ParameterizedTest
    @MethodSource("volleyball.importer.TestParameter#getDateString")
    @DisplayName("convert a text to a date object")
    public void testConvertText2Date(String dateString) {
        LocalDate date = ImporterUtils.string2Date(dateString);

        Assert.assertEquals(1, date.getDayOfMonth());
        Assert.assertEquals(1, date.getMonthValue());
        Assert.assertEquals(2010, date.getYear());
    }

    @ParameterizedTest
    @MethodSource("volleyball.importer.TestParameter#getPeriodString")
    @DisplayName("convert a text to a period object")
    public void testConvertText2Period(String periodString) {
        Assert.assertEquals(2010, ImporterUtils.string2SeasonStartYear(periodString));
        Assert.assertEquals(2011, ImporterUtils.string2SeasonEndYear(periodString));
    }

    @Test
    @DisplayName("convert an invalid text")
    public void testConvertInvalidText2Period() {
        String invalidPeriod = "aaaa/2011";
        Assert.assertEquals(0, ImporterUtils.string2SeasonStartYear(invalidPeriod));
        Assert.assertEquals(0, ImporterUtils.string2SeasonEndYear(invalidPeriod));

        invalidPeriod = "2010/aaaa";
        Assert.assertEquals(2010, ImporterUtils.string2SeasonStartYear(invalidPeriod));
        Assert.assertEquals(0, ImporterUtils.string2SeasonEndYear(invalidPeriod));
    }

    @ParameterizedTest
    @MethodSource("volleyball.importer.TestParameter#getTeamName")
    @DisplayName("parse club name from team name")
    public void testParseClubNameFromTeamName(String teamName) {
        Assert.assertEquals("team 1990", ImporterUtils.getClubNameFromTeamName(teamName));
    }

}