package volleyball.model.builder.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.club.ClubBuilder;

public class CommonClubBuilder extends ClubBuilder {

    private static final Logger logger = LogManager.getLogger(CommonClubBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        // check required parameter
        if (name == null || name.isEmpty()) {
            logger.error("the club name is required and can't be empty or NULL");
            validationResult = false;
        }

        return validationResult;
    }
}
