package volleyball.model.season;

import volleyball.model.IModelObject;
import volleyball.model.association.IAssociation;

import java.util.Optional;

public interface ISeason extends IModelObject {

    /**
     * @return the season start year
     */
    int getStartYear();

    /**
     * @return the season end year
     */
    int getEndYear();

    /**
     * @return the {@link IAssociation} reference or an empty object
     */
    Optional<IAssociation> getAssociation();
}
