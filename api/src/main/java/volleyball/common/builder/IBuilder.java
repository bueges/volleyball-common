package volleyball.common.builder;

import volleyball.common.model.IModelObject;

public interface IBuilder {

    IModelObject build() throws BuilderException;
}
