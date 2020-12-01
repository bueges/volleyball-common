package volleyball.model.repository.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.common.model.match.Match;

import java.util.Optional;

@Repository
public interface IMatchRepository extends JpaRepository<Match, Integer> {

    default Match saveObject(Match match) {
        Optional<Match> dbObjet = findAll().stream().filter(o -> o.equals(match)).findFirst();

        if (!dbObjet.isPresent()) {
            save(match);
            return match;
        } else {
            return dbObjet.get();
        }
    }
}


