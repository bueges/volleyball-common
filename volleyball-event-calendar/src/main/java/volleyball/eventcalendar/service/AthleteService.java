package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.repository.AthleteRepository;

@AllArgsConstructor
@Service
public class AthleteService {

    private AthleteRepository repository;


}
