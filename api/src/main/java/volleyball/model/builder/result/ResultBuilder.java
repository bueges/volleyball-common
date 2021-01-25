package volleyball.model.builder.result;

import volleyball.model.builder.IModelObjectBuilder;

import java.util.Optional;

public abstract class ResultBuilder implements IModelObjectBuilder {

    protected int setsTeam1;
    protected int setsTeam2;

    /**
     * @param setsTeam1 the team1 sets
     * @return the builder
     */
    public ResultBuilder withSetsTeam1(int setsTeam1) {
        this.setsTeam1 = setsTeam1;
        return this;
    }

    /**
     * @param setsTeam2 the team2 sets
     * @return the builder
     */
    public ResultBuilder withSetsTeam2(int setsTeam2) {
        this.setsTeam2 = setsTeam2;
        return this;
    }

    @Override
    public Optional<Result> build() {
        return validateData() ? Optional.ofNullable(new Result(setsTeam1, setsTeam2)) : Optional.empty();
    }
}
