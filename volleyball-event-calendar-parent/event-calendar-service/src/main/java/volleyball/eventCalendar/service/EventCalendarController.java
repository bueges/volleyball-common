package volleyball.eventCalendar.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import volleyball.model.athlete.Athlete;
import volleyball.model.event.Event;
import volleyball.model.match.Match;

import java.util.List;

@RestController
@Slf4j
public class EventCalendarController {

    @Autowired
    EventCalendarService calendarService;

    @GetMapping("/athleteCalendar")
    public List<Event> getAthleteCalendar(@RequestParam Athlete athlete) {
        return calendarService.getAthleteCalendar(athlete);
    }
}
