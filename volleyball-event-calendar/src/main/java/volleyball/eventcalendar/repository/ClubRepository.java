package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}
