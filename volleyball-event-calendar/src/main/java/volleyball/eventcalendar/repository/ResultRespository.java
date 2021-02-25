package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Result;

@Repository
public interface ResultRespository extends JpaRepository<Result, Long> {
}
