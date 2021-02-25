package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
