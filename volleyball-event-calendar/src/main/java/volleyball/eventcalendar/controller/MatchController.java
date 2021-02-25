package volleyball.eventcalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import volleyball.eventcalendar.service.MatchService;

@AllArgsConstructor
@Controller
public class MatchController {

    private MatchService service;
}
