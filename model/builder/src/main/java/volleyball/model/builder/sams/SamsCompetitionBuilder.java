package volleyball.model.builder.sams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.competition.CompetitionBuilder;

public class SamsCompetitionBuilder extends CompetitionBuilder {

    private static final Logger logger = LogManager.getLogger(SamsCompetitionBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        // check required parameter
        if (name == null || name.isEmpty()) {
            logger.error("the competition name is required and can't be empty or NULL");
            validationResult = false;
        }

        if (season == null) {
            logger.error("the season object is required and can't be NULL");
            validationResult = false;
        }

        return validationResult;
    }
}
