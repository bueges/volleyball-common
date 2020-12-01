package volleyball.common.model.team;


import volleyball.common.model.IModelObject;
import volleyball.common.model.club.IClub;
import volleyball.common.model.competition.ICompetition;

import java.util.Optional;

public interface ITeam extends IModelObject {

    String getName();

    Optional<IClub> getClub();

    Optional<ICompetition> getCompetition();
}
