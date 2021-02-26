package volleyball.eventcalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import volleyball.eventcalendar.service.AthleteService;

@AllArgsConstructor
@Controller
public class AthleteController {

    private AthleteService service;

    public ModelAndView getAllAthletes() {
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }
}
