package volleyball.common.model.association;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import volleyball.common.builder.BuilderException;


import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.ASSOCIATION_NAME;

class AssociationBuilderTest {

    private static final Logger logger = LogManager.getLogger(AssociationBuilderTest.class);

    @Test
    @DisplayName("build association")
    public void buildAssociation() throws BuilderException {
        Association association = Association.builder().withName(ASSOCIATION_NAME).build();
        logger.info("build association : [{}]", association);

        assertNotNull(association);

        assertNotNull(association.getName());
        assertEquals(ASSOCIATION_NAME, association.getName());
    }

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getAssociationBuilderName")
    @DisplayName("build association with invalid name and check BuilderException")
    public void buildAssociationWithInvalidName(String name) {
        assertThrows(BuilderException.class, () -> Association.builder().withName(name).build());
    }

}