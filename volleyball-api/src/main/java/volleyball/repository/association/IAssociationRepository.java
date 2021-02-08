package volleyball.repository.association;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.association.Association;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface IAssociationRepository extends JpaRepository<Association, Integer> {

    default Association saveObject(@NonNull Association association) {
        // define filter
        Predicate<Association> filterByName = a -> a.getName().equals(association.getName());

        Optional<Association> searchResult = findAll()
                .stream()
                .filter(filterByName)
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(association);
        }
    }
}
