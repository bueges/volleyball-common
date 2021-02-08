package volleyball.repository.match;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.association.Association;
import volleyball.model.match.Match;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public interface IMatchRepository extends JpaRepository<Match, Integer> {

    default Match saveObject(@NonNull Match match) {
        // define filter
        Predicate<Match> filterByDateTime = m -> m.getDateTime().equals(match.getDateTime());

        Predicate<Match> filterByTeam1 = m -> m.getTeam1().getId() == match.getTeam1().getId();
        Predicate<Match> filterByTeam2 = m -> m.getTeam2().getId() == match.getTeam2().getId();

        Optional<Match> searchResult = findAll()
                .stream()
                .filter(filterByDateTime.and(filterByTeam1).and(filterByTeam2))
                .findFirst();

        if (searchResult.isPresent()) {
            delete(searchResult.get());
        }

        return save(match);
    }
}
