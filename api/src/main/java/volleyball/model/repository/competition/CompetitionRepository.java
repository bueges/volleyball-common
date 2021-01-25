package volleyball.model.repository.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.builder.competition.Competition;

import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {

    default Competition saveObject(Competition competition) {
        Optional<Competition> dbObjet = findAll().stream().filter(o -> o.equals(competition)).findFirst();

        if (!dbObjet.isPresent()) {
            save(competition);
            return competition;
        } else {
            return dbObjet.get();
        }
    }
}


