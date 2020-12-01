package volleyball.common.builder.club;

import volleyball.common.builder.BuilderException;
import volleyball.common.builder.IBuilder;
import volleyball.common.model.club.IClub;

public interface IClubBuilder extends IBuilder {

    IClubBuilder withName(String name);

    @Override
    IClub build() throws BuilderException;
}
