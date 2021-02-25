package volleyball.eventCalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Result extends DefaultEntity {

    private int setsTeam1;
    private int setsTeam2;
}
