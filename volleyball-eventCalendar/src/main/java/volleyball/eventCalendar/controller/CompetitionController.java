package volleyball.eventCalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import volleyball.eventCalendar.service.CompetitionService;

@AllArgsConstructor
@Controller
public class CompetitionController {

    private CompetitionService service;
}
