package volleyball.model.repository.season;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.builder.season.Season;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {

    default Season saveObject(Season season) {
        Optional<Season> dbObjet = findAll().stream().filter(o -> o.equals(season)).findFirst();

        if (!dbObjet.isPresent()) {
            save(season);
            return season;
        } else {
            return dbObjet.get();
        }
    }
}


