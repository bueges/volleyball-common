package volleyball.eventCalendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AthleteDTO {

    private final String name;
    private final String preName;
    private final String birthday;
    private final String gender;

}
