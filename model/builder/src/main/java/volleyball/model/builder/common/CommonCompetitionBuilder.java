package volleyball.model.builder.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.competition.CompetitionBuilder;

public class CommonCompetitionBuilder extends CompetitionBuilder {

    private static final Logger logger = LogManager.getLogger(CommonCompetitionBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        // check required parameter
        if (name == null || name.isEmpty()) {
            logger.error("the competition name is required and can't be empty or NULL");
            validationResult = false;
        }

        // check optional parameter
        if (season == null) {
            logger.warn("the season object is NULL and will be ignored ");
        }

        return validationResult;
    }
}
