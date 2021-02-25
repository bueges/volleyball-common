package volleyball.eventcalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Result extends DefaultEntity {

    private int setsTeam1;
    private int setsTeam2;
}
