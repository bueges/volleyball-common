package volleyball.common.builder.season;

import volleyball.common.builder.BuilderException;
import volleyball.common.builder.IBuilder;
import volleyball.common.model.association.IAssociation;
import volleyball.common.model.season.ISeason;

public interface ISeasonBuilder extends IBuilder {

    ISeasonBuilder withPeriod(String period);

    ISeasonBuilder withAssociation(IAssociation association);

    @Override
    ISeason build() throws BuilderException;
}
