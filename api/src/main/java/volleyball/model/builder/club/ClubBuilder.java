package volleyball.model.builder.club;


import volleyball.model.builder.IModelObjectBuilder;

import java.util.Optional;

public abstract class ClubBuilder implements IModelObjectBuilder {

    protected String name;

    /**
     * @param name the club name
     * @return the builder
     */
    public ClubBuilder withName(String name) {
        this.name = name;
        return this;
    }


    @Override
    public Optional<Club> build() {
        return validateData() ? Optional.ofNullable(new Club(name)) : Optional.empty();
    }
}
