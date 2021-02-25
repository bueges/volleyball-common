package volleyball.eventcalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import volleyball.eventcalendar.service.AthleteService;

@AllArgsConstructor
@Controller
public class AthleteController {

    private AthleteService service;
}
