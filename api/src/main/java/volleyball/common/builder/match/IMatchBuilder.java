package volleyball.common.builder.match;

import volleyball.common.builder.BuilderException;
import volleyball.common.builder.IBuilder;
import volleyball.common.model.match.IMatch;
import volleyball.common.model.result.IResult;
import volleyball.common.model.team.ITeam;

public interface IMatchBuilder extends IBuilder {

    IMatchBuilder withDateTime(String dateTime);

    IMatchBuilder withNumber(String number);

    IMatchBuilder withTeam1(ITeam team1);

    IMatchBuilder withTeam2(ITeam team2);

    IMatchBuilder withResult(IResult result);

    @Override
    IMatch build() throws BuilderException;
}
