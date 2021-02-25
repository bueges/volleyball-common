package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
