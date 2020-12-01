package volleyball.common.repository;

import volleyball.common.model.IModelObject;

public interface IRepository {

    IModelObject saveObject(IModelObject modelObject);
}
