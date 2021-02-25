package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Athlete extends DefaultEntity {

    @NonNull
    private String name;

    @NonNull
    private String preName;

    @NonNull
    private LocalDate birthday;

    @NonNull
    private Gender gender;

    public enum Gender {
        MALE {
            @Override
            public String toString() {
                return "männlich";
            }
        },

        FEMALE {
            @Override
            public String toString() {
                return "weiblich";
            }
        };
    }
}
