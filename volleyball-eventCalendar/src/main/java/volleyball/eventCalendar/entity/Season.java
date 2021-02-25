package volleyball.eventCalendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Season extends DefaultEntity{

    private int startYear;
    private int endYear;
}
