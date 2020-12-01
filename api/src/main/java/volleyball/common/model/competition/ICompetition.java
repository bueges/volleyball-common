package volleyball.common.model.competition;

import volleyball.common.model.IModelObject;
import volleyball.common.model.season.ISeason;

import java.util.Optional;

public interface ICompetition extends IModelObject {

    String getName();

    Optional<ISeason> getSeason();
}
