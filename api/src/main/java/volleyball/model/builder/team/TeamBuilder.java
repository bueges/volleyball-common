package volleyball.model.builder.team;

import volleyball.model.builder.IModelObjectBuilder;
import volleyball.model.builder.club.Club;
import volleyball.model.builder.competition.Competition;

import java.util.Optional;

public abstract class TeamBuilder implements IModelObjectBuilder {

    protected String name;
    protected Club club;
    protected Competition competition;

    /**
     * @param name the team name
     * @return the builder
     */
    public TeamBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @param club the club object
     * @return the builder
     */
    public TeamBuilder withClub(Club club) {
        this.club = club;
        return this;
    }

    /**
     * @param competition the competition object
     * @return the builder
     */
    public TeamBuilder withCompetition(Competition competition) {
        this.competition = competition;
        return this;
    }

    @Override
    public Optional<Team> build() {
        return validateData() ? Optional.ofNullable(new Team(name, club, competition)) : Optional.empty();
    }
}
