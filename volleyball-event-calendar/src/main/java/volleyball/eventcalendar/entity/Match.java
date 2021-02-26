package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team1;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team2;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Result result;
}
