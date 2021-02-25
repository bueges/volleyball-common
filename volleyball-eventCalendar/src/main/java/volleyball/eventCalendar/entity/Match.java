package volleyball.eventCalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Match extends DefaultEntity {

    private LocalDateTime dateTime;

    private String number;

    @ManyToOne
    private Team team1;

    @ManyToOne
    private Team team2;

    @ManyToOne
    private Result result;
}
