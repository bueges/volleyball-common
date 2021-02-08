package volleyball.repository.club;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.club.Club;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface IClubRepository extends JpaRepository<Club, Integer> {

    default Club saveObject(@NonNull Club club) {
        // define filter
        Predicate<Club> filterByName = c -> c.getName().equals(club.getName());

        Optional<Club> searchResult = findAll()
                .stream()
                .filter(filterByName)
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(club);
        }
    }
}
