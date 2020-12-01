package volleyball.common.model.club;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import volleyball.common.builder.BuilderException;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.CLUB_NAME;

class ClubBuilderTest {

    private static final Logger logger = LogManager.getLogger(ClubBuilderTest.class);

    @Test
    @DisplayName("build club")
    public void buildClub() throws BuilderException {
        Club club = Club.builder().withName(CLUB_NAME).build();
        logger.info("build club : [{}]", club);

        assertNotNull(club);

        assertNotNull(club.getName());
        assertEquals(CLUB_NAME, club.getName());
    }

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getClubBuilderName")
    @DisplayName("build club with invalid name and check BuilderException")
    public void buildClubWithInvalidName(String name) {
        assertThrows(BuilderException.class, () -> Club.builder().withName(name).build());
    }
}