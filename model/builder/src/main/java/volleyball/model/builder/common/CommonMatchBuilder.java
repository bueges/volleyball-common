package volleyball.model.builder.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.match.MatchBuilder;

public class CommonMatchBuilder extends MatchBuilder {

    private static final Logger logger = LogManager.getLogger(CommonMatchBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        // check required parameter
        if (dateTime == null) {
            logger.error("the date time is required and can't be NULL");
            validationResult = false;
        }

        if (team1 == null) {
            logger.error("the team1 object is required and can't be NULL");
            validationResult = false;
        }

        if (team2 == null) {
            logger.error("the team2 object is required and can't be NULL");
            validationResult = false;
        }

        // check optional parameter
        if (number == null || number.isEmpty()) {
            logger.warn("the match number is empty or NULL and will be ignored");
        }

        if (result == null) {
            logger.warn("the result object is NULL and will be ignored");
        }

        return validationResult;
    }
}
