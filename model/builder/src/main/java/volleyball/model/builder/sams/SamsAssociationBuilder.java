package volleyball.model.builder.sams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.association.AssociationBuilder;

public class SamsAssociationBuilder extends AssociationBuilder {

    private static final Logger logger = LogManager.getLogger(SamsAssociationBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        // check required parameter
        if (name == null || name.isEmpty()) {
            logger.error("the association name is required and can't be empty or NULL");
            validationResult = false;
        }

        return validationResult;
    }
}
