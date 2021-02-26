package volleyball.eventcalendar.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import volleyball.eventcalendar.dto.CompetitionDTO;
import volleyball.eventcalendar.entity.Competition;
import volleyball.eventcalendar.service.CompetitionService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class CompetitionController {

    private CompetitionService service;

    @GetMapping("/competitions")
    public ModelAndView getAllCompetitions() {
        ModelAndView modelAndView = new ModelAndView("competitions");
        List<Competition> competitionList = service.getAllCompetitions();

        List<CompetitionDTO> dtoList = new ArrayList();
        competitionList.stream().forEach(c -> {
            CompetitionDTO dto = new CompetitionDTO(c.getName(), c.getSeason().getStartYear() + " / " + c.getSeason().getEndYear());
            dtoList.add(dto);
        });
        modelAndView.addObject("competitions", dtoList);

        return modelAndView;
    }
}
