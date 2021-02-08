package volleyball.model.competition;

import lombok.*;
import volleyball.model.season.ISeason;
import volleyball.model.season.Season;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class Competition implements ICompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    // required field
    @NonNull
    @Getter
    @EqualsAndHashCode.Exclude
    private String name;

    //optional field
    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Season season;

    public Optional<ISeason> getSeason() {
        return Optional.ofNullable(season);
    }
}
