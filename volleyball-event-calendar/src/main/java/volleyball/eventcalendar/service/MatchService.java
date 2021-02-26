package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Athlete;
import volleyball.eventcalendar.entity.Match;
import volleyball.eventcalendar.repository.MatchRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class MatchService {

    private MatchRepository repository;

    public List<Match> getAllMatches() {
        return repository.findAll();
    }
}
