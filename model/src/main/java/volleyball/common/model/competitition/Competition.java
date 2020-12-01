package volleyball.common.model.competitition;

import lombok.*;
import org.springframework.data.annotation.Id;
import volleyball.common.model.competition.ICompetition;
import volleyball.common.model.season.ISeason;
import volleyball.common.model.season.Season;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Competition implements ICompetition {

    public static CompetitionBuilder builder() {
        return new CompetitionBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @NonNull
    @Getter
    private final String name;

    @EqualsAndHashCode.Exclude
    private final Season season;

    public Optional<ISeason> getSeason() {
        return Optional.ofNullable(season);
    }

}
