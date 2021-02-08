package volleyball.model.match;

import lombok.*;
import volleyball.model.result.IResult;
import volleyball.model.result.Result;
import volleyball.model.team.Team;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class Match implements IMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    // required field
    @NonNull
    @Getter
    @EqualsAndHashCode.Exclude
    private LocalDateTime dateTime;

    // required field
    @NonNull
    @Getter
    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Team team1;

    // required field
    @NonNull
    @Getter
    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Team team2;

    //optional field
    @Getter
    @EqualsAndHashCode.Exclude
    private String number;

    //optional field
    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Result result;

    public Optional<IResult> getResult() {
        return Optional.ofNullable(result);
    }

//    @Override
//    public void updateResult(IResult result) {
//        this.result = (Result) result;
//    }
}
