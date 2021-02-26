package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Result;

import java.util.Optional;

@Repository
public interface ResultRespository extends JpaRepository<Result, Long> {

    Optional<Result> findResultBySetsTeam1AndSetsTeam2(int setsTeam1, int setsTeam2);
}
