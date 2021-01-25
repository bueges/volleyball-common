package volleyball.model.builder.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.team.TeamBuilder;

public class CommonTeamBuilder extends TeamBuilder {

    private static final Logger logger = LogManager.getLogger(CommonTeamBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        // check required parameter
        if (name == null || name.isEmpty()) {
            logger.error("the team name is required and can't be empty or NULL");
            validationResult = false;
        }

        // check optional parameter
        if (club == null) {
            logger.warn("the club object is NULL and will be ignored ");
        }

        if (competition == null) {
            logger.warn("the competition object is NULL and will be ignored ");
        }

        return validationResult;
    }
}
