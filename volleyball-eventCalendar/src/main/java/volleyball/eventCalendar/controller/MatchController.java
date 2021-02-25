package volleyball.eventCalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import volleyball.eventCalendar.service.MatchService;

@AllArgsConstructor
@Controller
public class MatchController {

    private MatchService service;
}
