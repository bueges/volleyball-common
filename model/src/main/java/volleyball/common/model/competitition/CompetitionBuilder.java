package volleyball.common.model.competitition;

import volleyball.common.builder.AbstractBuilder;
import volleyball.common.builder.BuilderException;
import volleyball.common.builder.competition.ICompetitionBuilder;
import volleyball.common.model.season.ISeason;
import volleyball.common.model.season.Season;

public class CompetitionBuilder extends AbstractBuilder implements ICompetitionBuilder {

    private String name;
    private ISeason season;

    @Override
    public CompetitionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CompetitionBuilder withSeason(ISeason season) {
        this.season = season;
        return this;
    }

    @Override
    public Competition build() throws BuilderException {
        isStringEmptyOrNull(name, "competitionName");
        isObjectNull(season, "season", true);

        return new Competition(name, (Season) season);
    }
}
