package volleyball.model.builder.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.season.SeasonBuilder;

public class CommonSeasonBuilder extends SeasonBuilder {

    private static final Logger logger = LogManager.getLogger(CommonSeasonBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        //TODO update error description
        // check required parameter
        if (startYear < SEASON_MIN_YEAR) {
            logger.error("the the season start year < " + SEASON_MIN_YEAR);
            validationResult = false;
        }

        if (endYear < SEASON_MIN_YEAR) {
            logger.error("the season end year < " + SEASON_MIN_YEAR);
            validationResult = false;
        }

        if (endYear == startYear) {
            logger.error("invalid season period : [{}/{}] start and end year can' be equal", startYear, endYear);
            validationResult = false;
        }

        if (endYear < startYear) {
            logger.error("invalid season period : [{}/{}] end year can't be < start year", startYear, endYear);
            validationResult = false;
        }

        if (endYear - startYear > 1) {
            logger.error("invalid season period length : [{}/{}]", startYear, endYear);
            validationResult = false;
        }

        // check optional parameter
        if (association == null) {
            logger.warn("the association object is NULL and will be ignored ");
        }

        return validationResult;
    }
}
