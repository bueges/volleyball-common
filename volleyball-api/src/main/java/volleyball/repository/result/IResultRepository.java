package volleyball.repository.result;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.competition.Competition;
import volleyball.model.result.Result;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public interface IResultRepository extends JpaRepository<Result, Integer> {

    default Result saveObject(@NonNull Result result) {
        // define filter
        Predicate<Result> filterByResult = r -> r.getSetsTeam1() == result.getSetsTeam1()
                && r.getSetsTeam2() == result.getSetsTeam2();

        Optional<Result> searchResult = findAll()
                .stream()
                .filter(filterByResult)
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(result);
        }
    }
}
