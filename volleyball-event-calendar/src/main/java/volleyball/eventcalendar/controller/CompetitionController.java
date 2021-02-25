package volleyball.eventcalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import volleyball.eventcalendar.service.CompetitionService;

@AllArgsConstructor
@Controller
public class CompetitionController {

    private CompetitionService service;
}
