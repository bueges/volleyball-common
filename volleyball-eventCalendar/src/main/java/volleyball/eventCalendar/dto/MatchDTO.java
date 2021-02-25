package volleyball.eventCalendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MatchDTO {

    private String number;
    private String dateTime;
    private String team1Name;
    private String team2Name;
}
