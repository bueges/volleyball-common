package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Association;

import java.util.Optional;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {

    Optional<Association> findAssociationByName(String name);
}
