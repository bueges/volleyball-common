package volleyball.repository.event;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.association.Association;
import volleyball.model.competition.Competition;
import volleyball.model.event.Event;
import volleyball.model.match.Match;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface IEventRepository extends JpaRepository<Event, Integer> {

    default Event saveObject(@NonNull Event event) {
        // define filter
        Predicate<Event> filterByMatch = e -> e.getMatch().getId() == event.getMatch().getId();

        Optional<Event> searchResult = findAll()
                .stream()
                .filter(filterByMatch)
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(event);
        }
    }

}
