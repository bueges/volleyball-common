package volleyball.repository.athlete;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.athlete.Athlete;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface IAthleteRepository extends JpaRepository<Athlete, Integer> {

    default Athlete saveObject(@NonNull Athlete athlete) {
        // define filter
        Predicate<Athlete> filterByName = a -> a.getName().equals(athlete.getName());

        Predicate<Athlete> filterByPreName = a -> a.getPreName().equals(athlete.getPreName());

        Predicate<Athlete> filterByGender = a -> a.getGender().equals(athlete.getGender());

        Predicate<Athlete> filterByBirthday = a -> a.getBirthday().equals(athlete.getBirthday());

        Optional<Athlete> searchResult = findAll()
                .stream()
                .filter(filterByName.and(filterByPreName).and(filterByGender).and(filterByBirthday))
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(athlete);
        }
    }
}
