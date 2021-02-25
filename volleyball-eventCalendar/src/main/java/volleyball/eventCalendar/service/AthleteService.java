package volleyball.eventCalendar.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import volleyball.eventCalendar.repository.AthleteRepository;

@AllArgsConstructor
@Service
public class AthleteService {

    private AthleteRepository repository;
}
