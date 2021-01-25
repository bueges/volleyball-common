package volleyball.model.builder.sams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.team.TeamBuilder;

public class SamsTeamBuilder extends TeamBuilder {

    private static final Logger logger = LogManager.getLogger(SamsTeamBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        // check required parameter
        if (name == null || name.isEmpty()) {
            logger.error("the team name is required and can't be empty or NULL");
            validationResult = false;
        }

        if (club == null) {
            logger.error("the club object is required and can't be NULL");
            validationResult = false;
        }

        if (competition == null) {
            logger.error("the competition object is required and can't be NULL");
            validationResult = false;
        }

        return validationResult;
    }
}
