package volleyball.model.repository.association;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.builder.association.Association;

import java.util.Optional;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Integer> {

    default Association saveObject(Association association) {
        Optional<Association> dbObjet = findAll().stream().filter(o -> o.equals(association)).findFirst();

        if (!dbObjet.isPresent()) {
            save(association);
            return association;
        } else {
            return dbObjet.get();
        }
    }
}
