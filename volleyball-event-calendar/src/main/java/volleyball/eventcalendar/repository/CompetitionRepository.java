package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Association;
import volleyball.eventcalendar.entity.Competition;
import volleyball.eventcalendar.entity.Season;

import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    Optional<Competition> findCompetitionByNameAndSeason(String name, Season season);
}
