package volleyball.eventCalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventCalendar.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
