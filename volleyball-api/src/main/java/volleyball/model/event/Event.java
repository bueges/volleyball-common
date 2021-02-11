package volleyball.model.event;

import lombok.*;
import volleyball.model.match.Match;
import volleyball.model.season.Season;

import javax.persistence.*;

@Entity
@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class Event implements IEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    //required field
    @NonNull
    @Getter
    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Match match;
}
