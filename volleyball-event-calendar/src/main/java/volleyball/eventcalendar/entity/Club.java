package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Club extends DefaultEntity {

    @NonNull
    @Column(unique = true)
    private String name;
}
