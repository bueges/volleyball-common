package volleyball.model.builder.club;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestConstants.CLUB1_NAME;

class ClubTest {

    private static final Logger logger = LogManager.getLogger(ClubTest.class);

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getClubName")
    @DisplayName("create club with valid name")
    public void testCreateAssociationWithValidName(String name) {
        Club club = new Club(name);
        logger.info("create club : {}", club);

        Assertions.assertNotNull(club);

        Assertions.assertNotNull(club.getName());
        assertEquals(name, club.getName());
    }

    @Test
    @DisplayName("check NullPointerException when create club with NULL name")
    public void testCheckNullPointerExceptionWhenCreateClubWithNULLName() {
        assertThrows(NullPointerException.class, () -> new Club(null));
    }

    @Test
    @DisplayName("compare two equal clubs")
    public void compareTwoEqualClubs() {
        Club club1 = new Club(CLUB1_NAME);
        Club club2 = new Club(CLUB1_NAME);

        logger.info("compare clubs : ");
        logger.info("club 1 : {}", club1);
        logger.info("club 2 : {}", club2);

        assertEquals(club1, club2);
    }

    @Test
    @DisplayName("compare two clubs with different name")
    public void compareTwoClubsWithDifferentName() {
        Club club1 = new Club(CLUB1_NAME);
        Club club2 = new Club("other-name");

        logger.info("compare clubs : ");
        logger.info("club 1 : {}", club1);
        logger.info("club 2 : {}", club2);

        assertNotEquals(club1, club2);
    }
}