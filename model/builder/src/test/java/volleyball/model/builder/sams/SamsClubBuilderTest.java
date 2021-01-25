package volleyball.model.builder.sams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import volleyball.model.builder.club.Club;
import volleyball.model.builder.common.CommonClubBuilder;

import java.util.Optional;

import static volleyball.TestConstants.CLUB1_NAME;

class SamsClubBuilderTest {

    // object under test
    private CommonClubBuilder builder = new CommonClubBuilder();

    @Test
    @DisplayName("build club object with valid data")
    public void testBuildClubObjectWithValidData() {
        Optional<Club> club = builder.withName(CLUB1_NAME).build();

        Assertions.assertNotNull(club);
        Assertions.assertTrue(club.isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getInvalidClubName")
    @DisplayName("build club object with invalid name")
    public void testBuildClubObjectWithInvalidName(String name) {
        Optional<Club> club = builder.withName(name).build();

        Assertions.assertNotNull(club);
        Assertions.assertFalse((club.isPresent()));
    }
}