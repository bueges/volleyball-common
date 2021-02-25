package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.*;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Association extends DefaultEntity {

    @NonNull
    @Column(unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Season season;
}
