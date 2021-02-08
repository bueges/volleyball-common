package volleyball.tools.parser;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Optional;

@Builder(setterPrefix = "with")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ParserResult implements IParserResult {

    private final String associationName;
    private final Integer seasonStartYear;
    private final Integer seasonEndYear;
    private final String competitionName;
    private final LocalDateTime matchDateTime;
    private final String matchNumber;
    private final Integer setsTeam1;
    private final Integer setsTeam2;
    private final String club1Name;
    private final String team1Name;
    private final String club2Name;
    private final String team2Name;

    @Override
    public Optional<String> getAssociationName() {
        return Optional.ofNullable(associationName);
    }

    @Override
    public Optional<Integer> getSeasonStartYear() {
        return Optional.ofNullable(seasonStartYear);
    }

    @Override
    public Optional<Integer> getSeasonEndYear() {
        return Optional.ofNullable(seasonEndYear);
    }

    @Override
    public Optional<String> getCompetitionName() {
        return Optional.ofNullable(competitionName);
    }

    @Override
    public Optional<LocalDateTime> getMatchDateTime() {
        return Optional.ofNullable(matchDateTime);
    }

    @Override
    public Optional<String> getMatchNumber() {
        return Optional.ofNullable(matchNumber);
    }

    @Override
    public Optional<Integer> getSetsTeam1() {
        return Optional.ofNullable(setsTeam1);
    }

    @Override
    public Optional<Integer> getSetsTeam2() {
        return Optional.ofNullable(setsTeam2);
    }

    @Override
    public Optional<String> getClub1Name() {
        return Optional.ofNullable(club1Name);
    }

    @Override
    public Optional<String> getTeam1Name() {
        return Optional.ofNullable(team1Name);
    }

    @Override
    public Optional<String> getClub2Name() {
        return Optional.ofNullable(club2Name);
    }

    @Override
    public Optional<String> getTeam2Name() {
        return Optional.ofNullable(team2Name);
    }
}
