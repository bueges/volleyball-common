package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Athlete;
import volleyball.eventcalendar.entity.Competition;
import volleyball.eventcalendar.repository.AthleteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AthleteService {

    private AthleteRepository repository;

    public List<Athlete> getAllAthletes() {
        return repository.findAll();
    }
}
