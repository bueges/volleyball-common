package volleyball.common.model.result;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.common.builder.AbstractBuilder;
import volleyball.common.builder.BuilderException;
import volleyball.common.builder.result.IResultBuilder;

import java.util.List;

public class ResultBuilder extends AbstractBuilder implements IResultBuilder {

    private static final Logger logger = LogManager.getLogger(ResultBuilder.class);

    private String result;

    @Override
    public ResultBuilder withResult(String result) {
        this.result = result;
        return this;
    }

    @Override
    public Result build() throws BuilderException {
        isStringEmptyOrNull(result, "result");
        List<String> tmpResult = splitString(result, "result", ":");
        int team1Sets = convertStringToInt(tmpResult.get(0), "tmpResult");
        int team2Sets = convertStringToInt(tmpResult.get(1), "tmpResult");

        if (team1Sets < 0 || team1Sets > 3) {
            String errorMsg = "invalid parameter : team1Sets [" + team1Sets + "] out of range [0, 3]";
            logger.error(errorMsg);
            throw new BuilderException(errorMsg);
        }

        if (team2Sets < 0 || team2Sets > 3) {
            String errorMsg = "invalid parameter : team2Sets [" + team2Sets + "] out of range [0, 3]";
            logger.error(errorMsg);
            throw new BuilderException(errorMsg);
        }

        if (team2Sets > 0 && team1Sets == team2Sets) {
            String errorMsg = "invalid parameter : team1Sets [" + team1Sets + "] and team2Sets [" + team2Sets + "] can't be equal";
            logger.error(errorMsg);
            throw new BuilderException(errorMsg);
        }

        return new Result(team1Sets, team2Sets);
    }
}
