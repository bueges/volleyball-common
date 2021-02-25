package volleyball.eventCalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import volleyball.eventCalendar.service.AthleteService;

@AllArgsConstructor
@Controller
public class AthleteController {

    private AthleteService service;
}
