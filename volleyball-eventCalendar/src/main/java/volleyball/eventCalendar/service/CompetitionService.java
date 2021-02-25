package volleyball.eventCalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventCalendar.repository.CompetitionRepository;

@AllArgsConstructor
@Service
public class CompetitionService {

    private CompetitionRepository repository;
}
