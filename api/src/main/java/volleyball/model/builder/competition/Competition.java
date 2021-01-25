package volleyball.model.builder.competition;

import lombok.*;
import volleyball.model.builder.IModelObject;
import volleyball.model.builder.season.Season;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Entity
public class Competition implements IModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;


    @Getter
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Season season;

    /**
     * constructor
     *
     * @param name   the competition name
     * @param season the season reference
     */
    protected Competition(@NonNull String name, Season season) {
        this.name = name;
        this.season = season;
    }

    public Optional<Season> getSeason() {
        return Optional.ofNullable(season);
    }


}
