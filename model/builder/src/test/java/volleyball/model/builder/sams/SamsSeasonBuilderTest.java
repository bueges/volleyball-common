package volleyball.model.builder.sams;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import volleyball.model.builder.association.Association;
import volleyball.model.builder.common.CommonSeasonBuilder;
import volleyball.model.builder.season.Season;

import java.util.Optional;

import static volleyball.TestConstants.SEASON_END_YEAR;
import static volleyball.TestConstants.SEASON_START_YEAR;

class SamsSeasonBuilderTest {

    // object under test
    private CommonSeasonBuilder builder = new CommonSeasonBuilder();

    @Test
    @DisplayName("build season object with valid data")
    public void testBuildSeasonObjectWithValidData() {
        Optional<Season> season = builder
                .withStartYear(SEASON_START_YEAR)
                .withEndYear(SEASON_END_YEAR)
                .withAssociation(Mockito.mock(Association.class))
                .build();

        Assertions.assertNotNull(season);
        Assertions.assertTrue(season.isPresent());
    }

    @Test
    @DisplayName("build season object without start year")
    public void testBuildSeasonObjectWithoutStartYear() {
        Optional<Season> season = builder
                .withEndYear(SEASON_END_YEAR)
                .withAssociation(Mockito.mock(Association.class))
                .build();

        Assertions.assertNotNull(season);
        Assertions.assertFalse(season.isPresent());
    }

    @Test
    @DisplayName("build season object without end year")
    public void testBuildSeasonObjectWithoutEndYear() {
        Optional<Season> season = builder
                .withStartYear(SEASON_START_YEAR)
                .withAssociation(Mockito.mock(Association.class))
                .build();

        Assertions.assertNotNull(season);
        Assertions.assertFalse(season.isPresent());
    }

    @Test
    @DisplayName("build season object without association")
    public void testBuildSeasonObjectWithoutAssociation() {
        Optional<Season> season = builder
                .withStartYear(SEASON_START_YEAR)
                .withEndYear(SEASON_END_YEAR)
                .build();

        Assertions.assertNotNull(season);
        Assertions.assertTrue(season.isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getInvalidSeasonPeriod")
    @DisplayName("build season object with invalid period")
    public void testBuildSeasonObjectWithInvalidPeriod(Pair<Integer, Integer> period) {
        Optional<Season> season = builder
                .withStartYear(period.getLeft())
                .withEndYear(period.getRight())
                .withAssociation(Mockito.mock(Association.class))
                .build();

        Assertions.assertNotNull(season);
        Assertions.assertFalse(season.isPresent());
    }
}