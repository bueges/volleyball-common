package volleyball.model.builder.team;

import lombok.*;
import volleyball.model.builder.IModelObject;
import volleyball.model.builder.club.Club;
import volleyball.model.builder.competition.Competition;

import javax.persistence.*;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
@Entity
public class Team implements IModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @Getter
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Club club;

    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Competition competition;

    /**
     * constructor
     *
     * @param name        the team name
     * @param club        the club reference
     * @param competition the competition reference
     */
    protected Team(@NonNull String name, Club club, Competition competition) {
        this.name = name;
        this.club = club;
        this.competition = competition;
    }

    public Optional<Club> getClub() {
        return Optional.ofNullable(club);
    }

    public Optional<Competition> getCompetition() {
        return Optional.ofNullable(competition);
    }
}
