package volleyball.model.builder.association;

import volleyball.model.builder.IModelObjectBuilder;

import java.util.Optional;

public abstract class AssociationBuilder implements IModelObjectBuilder {

    protected String name;

    /**
     * @param name the association name
     * @return the builder
     */
    public AssociationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Optional<Association> build() {
        return validateData() ? Optional.ofNullable(new Association(name)) : Optional.empty();
    }
}
