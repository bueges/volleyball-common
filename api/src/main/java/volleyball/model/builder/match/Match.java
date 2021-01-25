package volleyball.model.builder.match;

import lombok.*;
import volleyball.model.builder.IModelObject;
import volleyball.model.builder.result.Result;
import volleyball.model.builder.team.Team;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Entity
public class Match implements IModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @Getter
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    private Team team1;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter
    private Team team2;

    @Getter
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    private Result result;

    /**
     * constructor
     *
     * @param dateTime the match date time
     * @param team1    the first team
     * @param team2    the second team
     * @param number   the match number
     * @param result   the match result
     */
    protected Match(@NonNull LocalDateTime dateTime, @NonNull Team team1, @NonNull Team team2, String number, Result result) {
        this.dateTime = dateTime;
        this.team1 = team1;
        this.team2 = team2;
        this.number = number;
        this.result = result;
    }

    public Optional<Result> getResult() {
        return Optional.ofNullable(result);
    }
}
