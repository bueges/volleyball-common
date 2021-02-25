package volleyball.eventCalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import volleyball.eventCalendar.service.TeamService;

@AllArgsConstructor
@Controller
public class TeamController {

    private TeamService service;
}
