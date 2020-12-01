package volleyball.common.model.match;

import volleyball.common.builder.AbstractBuilder;
import volleyball.common.builder.BuilderException;
import volleyball.common.builder.match.IMatchBuilder;
import volleyball.common.model.result.IResult;
import volleyball.common.model.result.Result;
import volleyball.common.model.team.ITeam;
import volleyball.common.model.team.Team;

import java.time.LocalDateTime;

public class MatchBuilder extends AbstractBuilder implements IMatchBuilder {

    private String dateTimeText;
    private String number;
    private ITeam team1;
    private ITeam team2;
    private IResult result;

    @Override
    public MatchBuilder withDateTime(String dateTime) {
        this.dateTimeText = dateTime;
        return this;
    }

    @Override
    public MatchBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public MatchBuilder withTeam1(ITeam team1) {
        this.team1 = team1;
        return this;
    }

    @Override
    public MatchBuilder withTeam2(ITeam team2) {
        this.team2 = team2;
        return this;
    }

    @Override
    public MatchBuilder withResult(IResult result) {
        this.result = result;
        return this;
    }

    @Override
    public Match build() throws BuilderException {
        isStringEmptyOrNull(number, "matchNumber", true);
        isObjectNull(team1, "team1");
        isObjectNull(team2, "team2");
        isObjectNull(result, "result", true);

        LocalDateTime dateTime = convertStringToDateTime(dateTimeText, "dateTimeText");
        isObjectNull(dateTime, "dateTime");

        return new Match(dateTime, number, (Team) team1, (Team) team2, (Result) result);
    }
}
