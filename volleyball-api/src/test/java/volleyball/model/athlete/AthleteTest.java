package volleyball.model.athlete;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.*;

@Slf4j
public class AthleteTest {

    @Test
    @DisplayName("create athlete")
    public void createAthlete() {
        Athlete athlete = new Athlete(null, ATHLETE_NAME, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.MALE);
        log.info("create athlete : {}", athlete);

        assertNotNull(athlete);

        assertNotNull(athlete.getPreName());
        assertEquals(ATHLETE_PRENAME, athlete.getPreName());

        assertNotNull(athlete.getBirthday());
        assertEquals(ATHLETE_BIRTHDAY, athlete.getBirthday());
    }

    @Test
    @DisplayName("check NullPointerException when create athlete with null name")
    public void checkNullPointerExceptionWhenCreateAthleteWithNullName() {
        assertThrows(NullPointerException.class, () -> new Athlete(null, null, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create athlete with null preName")
    public void throwsNullPointerExceptionWhenCreateAthleteWithNullPreName() {
        assertThrows(NullPointerException.class, () -> new Athlete(null, ATHLETE_NAME, null, ATHLETE_BIRTHDAY, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create athlete with null birthday")
    public void checkNullPointerExceptionWhenCreateAthleteWithNullBirthday() {
        assertThrows(NullPointerException.class, () -> new Athlete(null, ATHLETE_NAME, ATHLETE_PRENAME, null, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create athlete with null gender")
    public void checkNullPointerExceptionWhenCreateAthleteWithNullGender() {
        assertThrows(NullPointerException.class, () -> new Athlete(null, ATHLETE_NAME, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, null));
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getAthleteName")
    @DisplayName("compare athletes with same ID")
    public void compareAthletesWithSameID() {
        Athlete athlete1 = new Athlete(1, ATHLETE_NAME, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.MALE);
        Athlete athlete2 = new Athlete(1, ATHLETE_NAME, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.MALE);
        Athlete athlete3 = new Athlete(1, "other-name", ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.MALE);
        Athlete athlete4 = new Athlete(1, ATHLETE_NAME, "other-prename", ATHLETE_BIRTHDAY, Gender.MALE);
        Athlete athlete5 = new Athlete(1, ATHLETE_NAME, ATHLETE_PRENAME, LocalDate.now(), Gender.MALE);
        Athlete athlete6 = new Athlete(1, ATHLETE_NAME, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.FEMALE);

        log.info("compare athletes : ");
        log.info("athlete 1 : {}", athlete1);
        log.info("athlete 2 : {}", athlete2);
        log.info("athlete 3 : {}", athlete3);
        log.info("athlete 4 : {}", athlete4);
        log.info("athlete 5 : {}", athlete5);
        log.info("athlete 6 : {}", athlete6);

        assertEquals(athlete1, athlete2);
        assertEquals(athlete1, athlete3);
        assertEquals(athlete1, athlete4);
        assertEquals(athlete1, athlete5);
        assertEquals(athlete1, athlete6);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getAthleteName")
    @DisplayName("compare athletes with different ID")
    public void compareMembersWithDifferentID() {
        Athlete athlete1 = new Athlete(1, ATHLETE_NAME, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.MALE);
        Athlete athlete2 = new Athlete(2, ATHLETE_NAME, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.MALE);
        Athlete athlete3 = new Athlete(3, "other-name", ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.MALE);
        Athlete athlete4 = new Athlete(4, ATHLETE_NAME, "other-prename", ATHLETE_BIRTHDAY, Gender.MALE);
        Athlete athlete5 = new Athlete(5, ATHLETE_NAME, ATHLETE_PRENAME, LocalDate.now(), Gender.MALE);
        Athlete athlete6 = new Athlete(6, ATHLETE_NAME, ATHLETE_PRENAME, ATHLETE_BIRTHDAY, Gender.FEMALE);

        log.info("compare athletes : ");
        log.info("athlete 1 : {}", athlete1);
        log.info("athlete 2 : {}", athlete2);
        log.info("athlete 3 : {}", athlete3);
        log.info("athlete 4 : {}", athlete4);
        log.info("athlete 5 : {}", athlete5);
        log.info("athlete 6 : {}", athlete6);

        assertNotEquals(athlete1, athlete2);
        assertNotEquals(athlete1, athlete3);
        assertNotEquals(athlete1, athlete4);
        assertNotEquals(athlete1, athlete5);
        assertNotEquals(athlete1, athlete6);
    }
}
