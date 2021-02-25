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
    @Column(unique = true)
    private String name;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Association association;
}
