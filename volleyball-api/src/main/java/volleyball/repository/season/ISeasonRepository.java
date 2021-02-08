package volleyball.repository.season;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.season.Season;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface ISeasonRepository extends JpaRepository<Season, Integer> {

    default Season saveObject(Season season) {
        // define filters
        Predicate<Season> filterByPeriod = s -> s.getStartYear() == season.getStartYear() && s.getEndYear() == season.getEndYear();

        Predicate<Season> filterByAssociation = s -> {
            if (season.getAssociation().isPresent()) {
                return s.getAssociation().isPresent() && s.getAssociation().get().getId() == season.getAssociation().get().getId();
            } else {
                return !s.getAssociation().isPresent();
            }
        };

        Optional<Season> searchResult = findAll()
                .stream()
                .filter(filterByPeriod.and(filterByAssociation))
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(season);
        }
    }
}
