package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
