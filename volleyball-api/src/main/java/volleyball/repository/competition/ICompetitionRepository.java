package volleyball.repository.competition;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.competition.Competition;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Integer> {

    default Competition saveObject(@NonNull Competition competition) {
        // define filter
        Predicate<Competition> filterByName = c -> c.getName().equals(competition.getName());

        Predicate<Competition> filterBySeason = c -> {
            if (competition.getSeason().isPresent()) {
                return c.getSeason().isPresent() && c.getSeason().get().getId() == competition.getSeason().get().getId();
            } else {
                return !c.getSeason().isPresent();
            }
        };

        Optional<Competition> searchResult = findAll()
                .stream()
                .filter(filterByName.and(filterBySeason))
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(competition);
        }
    }
}
