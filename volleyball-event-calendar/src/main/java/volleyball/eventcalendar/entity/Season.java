package volleyball.eventcalendar.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Season extends DefaultEntity {

    private int startYear;
    private int endYear;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Association association;
}
