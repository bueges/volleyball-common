package volleyball.common.model.team;

import volleyball.common.builder.AbstractBuilder;
import volleyball.common.builder.BuilderException;
import volleyball.common.builder.team.ITeamBuilder;
import volleyball.common.model.club.Club;
import volleyball.common.model.club.IClub;
import volleyball.common.model.competition.ICompetition;
import volleyball.common.model.competitition.Competition;

public class TeamBuilder extends AbstractBuilder implements ITeamBuilder {

    private String name;
    private IClub club;
    private ICompetition competition;

    @Override
    public TeamBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TeamBuilder withClub(IClub club) {
        this.club = club;
        return this;
    }

    @Override
    public TeamBuilder withCompetition(ICompetition competition) {
        this.competition = competition;
        return this;
    }

    @Override
    public Team build() throws BuilderException {
        isStringEmptyOrNull(name, "teamName");
        isObjectNull(club, "club", true);
        isObjectNull(competition, "competition", true);

        return new Team(name, (Club) club, (Competition) competition);
    }
}
