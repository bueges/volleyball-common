package volleyball.eventcalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Team extends DefaultEntity {

    private String name;

    @ManyToOne
    private Club club;

    @ManyToOne
    private Competition competition;
}
