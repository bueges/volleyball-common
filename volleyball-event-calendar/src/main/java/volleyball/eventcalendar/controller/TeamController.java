package volleyball.eventcalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import volleyball.eventcalendar.service.TeamService;

@AllArgsConstructor
@Controller
public class TeamController {

    private TeamService service;
}
