package volleyball.common.builder.competition;


import volleyball.common.builder.BuilderException;
import volleyball.common.builder.IBuilder;
import volleyball.common.model.competition.ICompetition;
import volleyball.common.model.season.ISeason;

public interface ICompetitionBuilder extends IBuilder {

    ICompetitionBuilder withName(String name);

    ICompetitionBuilder withSeason(ISeason season);

    @Override
    ICompetition build() throws BuilderException;
}
