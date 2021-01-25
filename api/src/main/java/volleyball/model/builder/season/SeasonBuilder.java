package volleyball.model.builder.season;

import volleyball.model.builder.IModelObjectBuilder;
import volleyball.model.builder.association.Association;

import java.util.Optional;

public abstract class SeasonBuilder implements IModelObjectBuilder {

    public final static int SEASON_MIN_YEAR = 2000;

    protected int startYear;
    protected int endYear;
    protected Association association;

    /**
     * @param startYear the season start year
     * @return the builder
     */
    public SeasonBuilder withStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    /**
     * @param endYear the season end year
     * @return the builder
     */
    public SeasonBuilder withEndYear(int endYear) {
        this.endYear = endYear;
        return this;
    }

    /**
     * @param association the {@link Association} object
     * @return the builder
     */
    public SeasonBuilder withAssociation(Association association) {
        this.association = association;
        return this;
    }

    @Override
    public Optional<Season> build() {
        return validateData() ? Optional.ofNullable(new Season(startYear, endYear, association)) : Optional.empty();
    }
}
