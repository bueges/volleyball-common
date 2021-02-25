package volleyball.eventCalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventCalendar.repository.MatchRepository;

@AllArgsConstructor
@Service
public class MatchService {

    private MatchRepository repository;
}
