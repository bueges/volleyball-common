package volleyball.model.repository.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.common.model.competitition.Competition;

import java.util.Optional;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Integer> {

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


