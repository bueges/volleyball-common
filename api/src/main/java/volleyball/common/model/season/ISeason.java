package volleyball.common.model.season;

import volleyball.common.model.IModelObject;
import volleyball.common.model.association.IAssociation;

import java.util.Optional;

public interface ISeason extends IModelObject {

    int getPeriodStart();

    int getPeriodEnd();

    Optional<IAssociation> getAssociation();
}
