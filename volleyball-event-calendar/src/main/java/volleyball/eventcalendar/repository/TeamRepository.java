package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Club;
import volleyball.eventcalendar.entity.Competition;
import volleyball.eventcalendar.entity.Team;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findTeamByNameAndClubAndCompetition(String teamName, Club club, Competition competition);
}
