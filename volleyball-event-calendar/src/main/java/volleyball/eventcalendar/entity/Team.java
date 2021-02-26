package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Team extends DefaultEntity {

    @NonNull
    private String name;

    @NonNull
    @ManyToOne
    private Club club;

    @NonNull
    @ManyToOne
    private Competition competition;
}
