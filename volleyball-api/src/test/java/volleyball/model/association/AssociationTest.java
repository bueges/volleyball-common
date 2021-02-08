package volleyball.model.association;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.ASSOCIATION_NAME;

@Slf4j
class AssociationTest {

    @Test
    @DisplayName("create association with valid name")
    public void testCreateAssociationWithValidName() {
        Association association = new Association(null, ASSOCIATION_NAME);
        log.info("create association : {}", association);

        Assertions.assertNotNull(association);

        Assertions.assertNotNull(association.getName());
        assertEquals(ASSOCIATION_NAME, association.getName());
    }

    @Test
    @DisplayName("check NullPointerException when create association with NULL name")
    public void testCheckNullPointerExceptionWhenCreateAssociationWithNULLName() {
        assertThrows(NullPointerException.class, () -> new Association(null, null));
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getAssociationName")
    @DisplayName("compare associations with same ID")
    public void compareAssociationsWithSameID(String otherAssociationName) {
        Association association1 = new Association(1, ASSOCIATION_NAME);
        Association association2 = new Association(1, otherAssociationName);

        log.info("compare associations : ");
        log.info("association 1 : {}", association1);
        log.info("association 2 : {}", association2);

        assertEquals(association1, association2);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getAssociationName")
    @DisplayName("compare associations with different ID")
    public void compareAssociationsWithDifferentID(String otherAssociationName) {
        Association association1 = new Association(1, ASSOCIATION_NAME);
        Association association2 = new Association(2, otherAssociationName);

        log.info("compare associations : ");
        log.info("association 1 : {}", association1);
        log.info("association 2 : {}", association2);

        assertNotEquals(association1, association2);
    }
}