package volleyball.common.model.competitition;

import lombok.*;
import volleyball.common.model.competition.ICompetition;
import volleyball.common.model.season.ISeason;
import volleyball.common.model.season.Season;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Competition implements ICompetition {

    public static CompetitionBuilder builder() {
        return new CompetitionBuilder();
    }

    @NonNull
    @Getter
    private final String name;

    @EqualsAndHashCode.Exclude
    private final Season season;

    public Optional<ISeason> getSeason() {
        return Optional.ofNullable(season);
    }

}
