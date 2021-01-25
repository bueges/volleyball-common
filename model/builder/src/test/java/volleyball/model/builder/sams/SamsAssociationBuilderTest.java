package volleyball.model.builder.sams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import volleyball.model.builder.association.Association;

import java.util.Optional;

import static volleyball.TestConstants.ASSOCIATION_NAME;

class SamsAssociationBuilderTest {

    // object under test
    private SamsAssociationBuilder builder = new SamsAssociationBuilder();

    @Test
    @DisplayName("build association object with valid data")
    public void testBuildAssociationObjectWithValidData() {
        Optional<Association> association = builder.withName(ASSOCIATION_NAME).build();

        Assertions.assertNotNull(association);
        Assertions.assertTrue(association.isPresent());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getInvalidAssociationName")
    @DisplayName("build association with invalid name")
    public void testBuildAssociationWithInvalidName(String name) {
        Optional<Association> association = builder.withName(name).build();

        Assertions.assertNotNull(association);
        Assertions.assertFalse(association.isPresent());
    }
}