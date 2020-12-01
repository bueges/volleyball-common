package volleyball.common.model.club;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.CLUB_NAME;

class ClubTest {

    private static final Logger logger = LogManager.getLogger(ClubTest.class);

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getClubName")
    @DisplayName("create club")
    public void createClub(String name) {
        Club club = new Club(name);
        logger.info("create club : [{}]", club);

        assertNotNull(club);

        assertNotNull(club.getName());
        assertEquals(name, club.getName());
    }

    @Test
    @DisplayName("create club with NULL name and check NULLPointerException")
    public void createClubWithNullName() {
        assertThrows(NullPointerException.class, () -> new Club(null));
    }

    @Test
    @DisplayName("compare two equal clubs")
    public void compareTwoEqualClubs() {
        Club club1 = new Club(CLUB_NAME);
        Club club2 = new Club(CLUB_NAME);

        logger.info("compare clubs : ");
        logger.info("club 1 : [{}]", club1);
        logger.info("club 2 : [{}]", club2);

        assertEquals(club1, club2);
    }

    @Test
    @DisplayName("compare two clubs with different name")
    public void compareTwoClubsWithDifferentName() {
        Club club1 = new Club(CLUB_NAME);
        Club club2 = new Club("other-name");

        logger.info("compare clubs : ");
        logger.info("club 1 : [{}]", club1);
        logger.info("club 2 : [{}]", club2);

        assertNotEquals(club1, club2);
    }
}