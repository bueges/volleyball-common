package volleyball.model.team;

import lombok.*;
import volleyball.model.club.Club;
import volleyball.model.club.IClub;
import volleyball.model.competition.Competition;
import volleyball.model.competition.ICompetition;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class Team implements ITeam {

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
    private Club club;

    //optional field
    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Competition competition;

    public Optional<IClub> getClub() {
        return Optional.ofNullable(club);
    }

    public Optional<ICompetition> getCompetition() {
        return Optional.ofNullable(competition);
    }
}
