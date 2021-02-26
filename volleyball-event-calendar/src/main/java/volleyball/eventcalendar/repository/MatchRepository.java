package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Match;
import volleyball.eventcalendar.entity.Team;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Optional<Match> findMatchByDateTimeAndNumberAndTeam1AndTeam2(LocalDateTime dateTime, String number, Team team1, Team team2);
}
