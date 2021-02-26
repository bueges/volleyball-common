package volleyball.eventcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.eventcalendar.entity.Athlete;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    Optional<Athlete> findAthletesByNameAndPreNameAndBirthdayAndGender(String name, String preName, LocalDate birthday, Athlete.Gender gender);
}
