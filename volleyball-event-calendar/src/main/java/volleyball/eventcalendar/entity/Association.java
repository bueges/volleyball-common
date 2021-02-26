package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.Entity;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Association extends DefaultEntity {

    @NonNull
    private String name;
}
