package volleyball.common.builder.association;

import volleyball.common.builder.BuilderException;
import volleyball.common.builder.IBuilder;
import volleyball.common.model.association.IAssociation;

public interface IAssociationBuilder extends IBuilder {

    IAssociationBuilder withName(String name);

    @Override
    IAssociation build() throws BuilderException;
}
