package volleyball.eventCalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventCalendar.entity.Association;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
}
