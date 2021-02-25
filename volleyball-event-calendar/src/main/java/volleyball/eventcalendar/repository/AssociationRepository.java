package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Association;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
}
