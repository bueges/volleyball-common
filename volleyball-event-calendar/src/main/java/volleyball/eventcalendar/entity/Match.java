package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Match extends DefaultEntity {

    @NonNull
    private LocalDateTime dateTime;

    @NonNull
    private String number;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team1;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team2;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Result result;
}
