package volleyball.model.builder.sams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.club.ClubBuilder;

public class SamsClubBuilder extends ClubBuilder {

    private static final Logger logger = LogManager.getLogger(SamsClubBuilder.class);

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
