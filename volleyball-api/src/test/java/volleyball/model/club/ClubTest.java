package volleyball.model.club;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.CLUB1_NAME;

@Slf4j
class ClubTest {

    @Test
    @DisplayName("create club with valid name")
    public void testCreateClubWithValidName() {
        Club club = new Club(null, CLUB1_NAME);
        log.info("create club : {}", club);

        Assertions.assertNotNull(club);

        Assertions.assertNotNull(club.getName());
        assertEquals(CLUB1_NAME, club.getName());
    }

    @Test
    @DisplayName("check NullPointerException when create club with NULL name")
    public void testCheckNullPointerExceptionWhenCreateClubWithNULLName() {
        assertThrows(NullPointerException.class, () -> new Club(null, null));
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getClubName")
    @DisplayName("compare clubs with same ID")
    public void compareClubsWithSameID(String otherClubName) {
        Club club1 = new Club(1, CLUB1_NAME);
        Club club2 = new Club(1, otherClubName);

        log.info("compare clubs : ");
        log.info("club 1 : {}", club1);
        log.info("club 2 : {}", club2);

        assertEquals(club1, club2);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getClubName")
    @DisplayName("compare clubs with different ID")
    public void compareClubsWithDifferentID(String otherClubName) {
        Club club1 = new Club(1, CLUB1_NAME);
        Club club2 = new Club(2, otherClubName);

        log.info("compare clubs : ");
        log.info("club 1 : {}", club1);
        log.info("club 2 : {}", club2);

        assertNotEquals(club1, club2);
    }
}