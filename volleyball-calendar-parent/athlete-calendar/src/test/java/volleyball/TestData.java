package volleyball;

import org.springframework.data.util.Pair;
import volleyball.model.athlete.Gender;
import volleyball.tools.parser.ParserResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class TestData {

    // athlete test constants
    public static final String ATHLETE_NAME = "name";
    public static final String ATHLETE_PRENAME = "preName";
    public static final LocalDate ATHLETE_BIRTHDAY = LocalDate.of(2000, 1, 1);
    public static final Gender ATHLETE_GENDER = Gender.MALE;
}
