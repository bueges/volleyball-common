package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.*;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Competition extends DefaultEntity {

    @NonNull
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Season season;
}
