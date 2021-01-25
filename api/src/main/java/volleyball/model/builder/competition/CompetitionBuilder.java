package volleyball.model.builder.competition;

import volleyball.model.builder.IModelObjectBuilder;
import volleyball.model.builder.season.Season;

import java.util.Optional;

public abstract class CompetitionBuilder implements IModelObjectBuilder {

    protected String name;
    protected Season season;

    /**
     * @param name the competition name
     * @return the builder
     */
    public CompetitionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @param season the season object
     * @return the builder
     */
    public CompetitionBuilder withSeason(Season season) {
        this.season = season;
        return this;
    }

    @Override
    public Optional<Competition> build() {
        return validateData() ? Optional.ofNullable(new Competition(name, season)) : Optional.empty();
    }
}
