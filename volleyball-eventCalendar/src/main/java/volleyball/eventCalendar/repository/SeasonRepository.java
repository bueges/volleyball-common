package volleyball.eventCalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventCalendar.entity.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}
