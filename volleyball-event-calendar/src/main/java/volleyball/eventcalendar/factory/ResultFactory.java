package volleyball.eventcalendar.factory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import volleyball.eventcalendar.entity.Association;
import volleyball.eventcalendar.entity.Result;
import volleyball.eventcalendar.repository.ResultRespository;

import java.util.Optional;

@AllArgsConstructor
@Component
public class ResultFactory {

    private ResultRespository repository;

    public Result createResult(int setsTeam1, int setsTeam2) {
        Optional<Result> dbObject = repository
                .findResultBySetsTeam1AndSetsTeam2(setsTeam1, setsTeam2);

        if (dbObject.isPresent()) {
            return dbObject.get();
        } else {
            return repository.save(Result.builder()
                    .withSetsTeam1(setsTeam1)
                    .withSetsTeam2(setsTeam2)
                    .build());
        }
    }
}
