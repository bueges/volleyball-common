package volleyball.common.model.team;

import lombok.*;
import volleyball.common.model.club.Club;
import volleyball.common.model.club.IClub;
import volleyball.common.model.competition.ICompetition;
import volleyball.common.model.competitition.Competition;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Team implements ITeam {

    public static TeamBuilder builder() {
        return new TeamBuilder();
    }

    @NonNull
    @Getter
    private final String name;

    @EqualsAndHashCode.Exclude
    private final Club club;

    @EqualsAndHashCode.Exclude
    private final Competition competition;

    @Override
    public Optional<IClub> getClub() {
        return Optional.ofNullable(club);
    }

    @Override
    public Optional<ICompetition> getCompetition() {
        return Optional.ofNullable(competition);
    }
}
