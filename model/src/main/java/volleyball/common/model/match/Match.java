package volleyball.common.model.match;

import lombok.*;
import org.springframework.data.annotation.Id;
import volleyball.common.model.result.IResult;
import volleyball.common.model.result.Result;
import volleyball.common.model.team.Team;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Match implements IMatch {

    public static MatchBuilder builder() {
        return new MatchBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @NonNull
    @Getter
    private final LocalDateTime dateTime;

    @NonNull
    @Getter
    private final String number;

    @NonNull
    @Getter
    private final Team team1;

    @NonNull
    @Getter
    private final Team team2;

    private final Result result;

    @Override
    public Optional<IResult> getResult() {
        return Optional.ofNullable(result);
    }
}
