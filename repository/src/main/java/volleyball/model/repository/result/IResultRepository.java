package volleyball.model.repository.result;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.common.model.result.Result;
import volleyball.common.model.season.Season;

import java.util.Optional;

@Repository
public interface IResultRepository extends JpaRepository<Result, Integer> {

    default Result saveObject(Result result) {
        Optional<Result> dbObjet = findAll().stream().filter(o -> o.equals(result)).findFirst();

        if (!dbObjet.isPresent()) {
            save(result);
            return result;
        } else {
            return dbObjet.get();
        }
    }
}


