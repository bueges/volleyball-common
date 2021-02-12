package volleyball.model.team;

import volleyball.model.IModelObject;
import volleyball.model.association.IAssociation;
import volleyball.model.athlete.Athlete;
import volleyball.model.athlete.IAthlete;
import volleyball.model.club.IClub;
import volleyball.model.competition.ICompetition;

import java.util.List;
import java.util.Optional;

public interface ITeam extends IModelObject {

    /**
     * @return the team name
     */
    String getName();

    /**
     * @return a list with {@link IAthlete} references
     */
    List<? extends IAthlete> getAthleteList();

    /**
     * @return the {@link IClub} reference or an empty object
     */
    Optional<IClub> getClub();

    /**
     * @return the {@link ICompetition} reference or an empty object
     */
    Optional<ICompetition> getCompetition();

}
