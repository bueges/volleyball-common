package volleyball.model.match;

import volleyball.model.IModelObject;
import volleyball.model.result.IResult;
import volleyball.model.team.ITeam;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IMatch extends IModelObject {

    /**
     * @return the match date time
     */
    LocalDateTime getDateTime();

    /**
     * @return the first {@link ITeam} object
     */
    ITeam getTeam1();

    /**
     * @return the second {@link ITeam} object
     */
    ITeam getTeam2();

    /**
     * @return the match number
     */
    String getNumber();

    /**
     * @return the {@link IResult} object or an empty object
     */
    Optional<IResult> getResult();

//    void updateResult(IResult result);
}
