package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Season;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

    Optional<Season> findSeasonByStartYearAndEndYear(int startYear, int endYear);
}
