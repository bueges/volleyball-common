package volleyball.model.builder.sams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.match.MatchBuilder;

public class SamsMatchBuilder extends MatchBuilder {

    private static final Logger logger = LogManager.getLogger(SamsMatchBuilder.class);

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

        if (number == null || number.isEmpty()) {
            logger.error("the match number is required and can't be empty or NULL");
            validationResult = false;
        }

        // check optional parameter
        if (result == null) {
            logger.warn("the result object is NULL and will be ignored");
        }

        return validationResult;
    }
}
