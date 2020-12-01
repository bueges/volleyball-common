package volleyball.common.model.association;


import volleyball.common.builder.AbstractBuilder;
import volleyball.common.builder.BuilderException;
import volleyball.common.builder.association.IAssociationBuilder;

public class AssociationBuilder extends AbstractBuilder implements IAssociationBuilder {

    private String name;

    public AssociationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Association build() throws BuilderException {
        isStringEmptyOrNull(name, "associationName");

        return new Association(name);
    }
}
