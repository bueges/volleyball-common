package volleyball.eventCalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventCalendar.repository.TeamRepository;

@AllArgsConstructor
@Service
public class TeamService {

    private TeamRepository repository;
}
