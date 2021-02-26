package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Team;
import volleyball.eventcalendar.repository.TeamRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class TeamService {

    private TeamRepository repository;

    public List<Team> getAllTeams() {
        return repository.findAll();
    }
}
