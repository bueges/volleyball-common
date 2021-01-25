package volleyball.model.builder.match;

import volleyball.model.builder.IModelObjectBuilder;
import volleyball.model.builder.result.Result;
import volleyball.model.builder.team.Team;

import java.time.LocalDateTime;
import java.util.Optional;

public abstract class MatchBuilder implements IModelObjectBuilder {

    protected LocalDateTime dateTime;
    protected String number;
    protected Team team1;
    protected Team team2;
    protected Result result;

    /**
     * @param dateTime the match date tim
     * @return the builder
     */
    public MatchBuilder withDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    /**
     * @param number the match number
     * @return the builder
     */
    public MatchBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    /**
     * @param team1 the {@link Team} object
     * @return the builder
     */
    public MatchBuilder withTeam1(Team team1) {
        this.team1 = team1;
        return this;
    }

    /**
     * @param team2 the {@link Team} object
     * @return the builder
     */
    public MatchBuilder withTeam2(Team team2) {
        this.team2 = team2;
        return this;
    }

    /**
     * @param result the {@link Result} object
     * @return the builder
     */
    public MatchBuilder withResult(Result result) {
        this.result = result;
        return this;
    }

    @Override
    public Optional<Match> build() {
        return validateData() ? Optional.ofNullable(new Match(dateTime, team1, team2, number, result)) : Optional.empty();
    }
}
