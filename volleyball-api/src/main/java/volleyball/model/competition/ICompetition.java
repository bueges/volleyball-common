package volleyball.model.competition;

import volleyball.model.IModelObject;
import volleyball.model.season.ISeason;

import java.util.Optional;

public interface ICompetition extends IModelObject {

    /**
     * @return the competition name
     */
    String getName();

    /**
     * @return the {@link ISeason} reference or an empty object
     */
    Optional<ISeason> getSeason();
}
