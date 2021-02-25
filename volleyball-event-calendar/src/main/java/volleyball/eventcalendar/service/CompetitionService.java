package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.repository.CompetitionRepository;

@AllArgsConstructor
@Service
public class CompetitionService {

    private CompetitionRepository repository;
}
