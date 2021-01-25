package volleyball.model.builder;

import java.util.Optional;

public interface IModelObjectBuilder {

    /**
     * validate the builder data and build the model object
     *
     * @return the build {@link IModelObject} or an empty object
     */
    Optional<? extends IModelObject> build();

    /**
     * @return true if the builder are valid
     */
    boolean validateData();
}
