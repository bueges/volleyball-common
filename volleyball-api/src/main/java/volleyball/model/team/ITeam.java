package volleyball.model.team;

import volleyball.model.IModelObject;
import volleyball.model.club.IClub;
import volleyball.model.competition.ICompetition;

import java.util.Optional;

public interface ITeam extends IModelObject {

    /**
     * @return the team name
     */
    String getName();

    /**
     * @return the {@link IClub} reference or an empty object
     */
    Optional<IClub> getClub();

    /**
     * @return the {@link ICompetition} reference or an empty object
     */
    Optional<ICompetition> getCompetition();

}
