package volleyball.importer;

import volleyball.TestConstants;

import java.util.stream.Stream;

public class TestParameter {

    // time test parameter
    public static Stream<String> getTimeString() {
        return Stream.of("14:30", "14:30:00");
    }

    // date test parameter
    public static Stream<String> getDateString() {
        return Stream.of("01.01.2010", "1.01.2010", "1.1.2010", "01.01.10", "1.01.10", "01.1.10", "1.1.10");
    }

    // period test parameter
    public static Stream<String> getPeriodString(){
        return Stream.of("2010/11", "2010/2011");
    }

    // club name test parameter
    public static Stream<String> getTeamName(){
        return Stream.of("team 1990", "team 1990 1", "team 1990 12");
    }
}
