package volleyball.modelData.athleteData;

import volleyball.model.athlete.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface IAthleteData {

    /**
     * @return the athlete name or an empty object
     */
    Optional<String> getAthleteName();

    /**
     * @return the athlete pre name or an empty object
     */
    Optional<String> getAthletePreName();

    /**
     * @return the athlete birthday or an empty object
     */
    Optional<LocalDate> getAthleteBirthday();

    /**
     * @return the athlete gender or an empty object
     */
    Optional<Gender> getAthleteGender();
}
