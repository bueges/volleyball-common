package volleyball.common.model.season;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import volleyball.common.builder.AbstractBuilder;
import volleyball.common.builder.BuilderException;
import volleyball.common.builder.season.ISeasonBuilder;
import volleyball.common.model.association.Association;
import volleyball.common.model.association.IAssociation;

import java.util.List;

public class SeasonBuilder extends AbstractBuilder implements ISeasonBuilder {

    private static final Logger logger = LogManager.getLogger(SeasonBuilder.class);

    private String period;
    private IAssociation association;

    @Override
    public SeasonBuilder withPeriod(String period) {
        this.period = period;
        return this;
    }

    @Override
    public SeasonBuilder withAssociation(IAssociation association) {
        this.association = association;
        return this;
    }

    @Override
    public Season build() throws BuilderException {
        isStringEmptyOrNull(period, "period");
        isObjectNull(association, "association", true);

        List<String> tmpPeriod = splitString(period, "result", "/");
        int periodStart = convertStringToInt(tmpPeriod.get(0), "tmpPeriod");
        int periodEnd = convertStringToInt(tmpPeriod.get(1), "tmpPeriod");

        if (periodStart > periodEnd) {
            String errorMsg = "invalid parameter : periodStart [" + periodStart + "] and  periodEnd [" + periodEnd + "] wrong order";
            logger.error(errorMsg);
            throw new BuilderException(errorMsg);
        }

        if (periodEnd - periodStart == 0 || periodEnd - periodStart > 1) {
            String errorMsg = "invalid parameter : periodStart [" + periodStart + "] and  periodEnd [" + periodEnd + "] wrong length";
            logger.error(errorMsg);
            throw new BuilderException(errorMsg);
        }

        return new Season(periodStart, periodEnd, (Association) association);
    }
}
