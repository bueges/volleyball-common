package volleyball.model.builder.sams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.model.builder.result.ResultBuilder;

public class SamsResultBuilder extends ResultBuilder {

    private static final Logger logger = LogManager.getLogger(SamsResultBuilder.class);

    @Override
    public boolean validateData() {
        boolean validationResult = true;

        // check required parameter
        if (setsTeam1 < 0 || setsTeam1 > 3) {
            logger.error("the sets team1 is required in range [0, 3] and can't be out of range : {}", setsTeam1);
            validationResult =  false;
        }

        if (setsTeam2 < 0 || setsTeam2 > 3) {
            logger.error("the sets team2 is required in range [0, 3] and can't be out of range : {}", setsTeam2);
            return false;
        }

        if (setsTeam1 == setsTeam2 && setsTeam1 > 0) {
            logger.error("the sets team1 and set sets team2 can't be equal : {}:{}", setsTeam1, setsTeam2);
            return false;
        }

        return validationResult;
    }
}
