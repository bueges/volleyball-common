package volleyball.common.model.club;

import volleyball.common.builder.AbstractBuilder;
import volleyball.common.builder.BuilderException;
import volleyball.common.builder.club.IClubBuilder;

public class ClubBuilder extends AbstractBuilder implements IClubBuilder {

    private String name;

    @Override
    public ClubBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Club build() throws BuilderException {
        isStringEmptyOrNull(name, "clubName");

        return new Club(name);
    }
}
