package volleyball.common.model.match;


import volleyball.common.model.IModelObject;
import volleyball.common.model.result.IResult;
import volleyball.common.model.team.ITeam;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IMatch extends IModelObject {

    LocalDateTime getDateTime();

    String getNumber();

    ITeam getTeam1();

    ITeam getTeam2();

    Optional<IResult> getResult();
}
