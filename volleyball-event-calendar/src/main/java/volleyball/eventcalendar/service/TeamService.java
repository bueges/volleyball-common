package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.repository.TeamRepository;

@AllArgsConstructor
@Service
public class TeamService {

    private TeamRepository repository;
}
