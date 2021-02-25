package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.repository.MatchRepository;

@AllArgsConstructor
@Service
public class MatchService {

    private MatchRepository repository;
}
