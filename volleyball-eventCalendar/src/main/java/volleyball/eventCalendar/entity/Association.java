package volleyball.eventCalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Association extends DefaultEntity {

    private String name;

    @ManyToOne
    private Season season;
}
