package volleyball.eventCalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventCalendar.entity.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
