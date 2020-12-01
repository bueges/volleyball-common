package volleyball.common.builder.team;


import volleyball.common.builder.BuilderException;
import volleyball.common.builder.IBuilder;
import volleyball.common.model.club.IClub;
import volleyball.common.model.competition.ICompetition;
import volleyball.common.model.team.ITeam;

public interface ITeamBuilder extends IBuilder {

    ITeamBuilder withName(String name);

    ITeamBuilder withClub(IClub club);

    ITeamBuilder withCompetition(ICompetition competition);

    @Override
    ITeam build() throws BuilderException;
}
