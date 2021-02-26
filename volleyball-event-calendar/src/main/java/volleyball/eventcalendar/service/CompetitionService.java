package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Competition;
import volleyball.eventcalendar.repository.CompetitionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CompetitionService {

    private CompetitionRepository repository;

    public List<Competition> getAllCompetitions() {
        return repository.findAll();
    }
}
