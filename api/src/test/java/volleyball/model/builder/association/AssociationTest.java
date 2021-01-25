package volleyball.model.builder.association;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestConstants.ASSOCIATION_NAME;

class AssociationTest {

    private static final Logger logger = LogManager.getLogger(AssociationTest.class);

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getAssociationName")
    @DisplayName("create association with valid name")
    public void testCreateAssociationWithValidName(String name) {
        Association association = new Association(name);
        logger.info("create association : {}", association);

        Assertions.assertNotNull(association);

        Assertions.assertNotNull(association.getName());
        assertEquals(name, association.getName());
    }

    @Test
    @DisplayName("check NullPointerException when create association with NULL name")
    public void testCheckNullPointerExceptionWhenCreateAssociationWithNULLName() {
        assertThrows(NullPointerException.class, () -> new Association(null));
    }

    @Test
    @DisplayName("compare two equal associations")
    public void compareTwoEqualAssociations() {
        Association association1 = new Association(ASSOCIATION_NAME);
        Association association2 = new Association(ASSOCIATION_NAME);

        logger.info("compare associations : ");
        logger.info("association 1 : {}", association1);
        logger.info("association 2 : {}", association2);

        assertEquals(association1, association2);
    }

    @Test
    @DisplayName("compare two associations with different name")
    public void compareTwoAssociationsWithDifferentName() {
        Association association1 = new Association(ASSOCIATION_NAME);
        Association association2 = new Association("other-name");

        logger.info("compare associations : ");
        logger.info("association 1 : {}", association1);
        logger.info("association 2 : {}", association2);

        assertNotEquals(association1, association2);
    }
}