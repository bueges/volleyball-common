package volleyball.modelData.athleteData;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import volleyball.model.athlete.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Builder(setterPrefix = "with")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class AthleteData implements IAthleteData {

    private final String athleteName;
    private final String athletePreName;
    private final LocalDate athleteBirthday;
    private final Gender athleteGender;

    @Override
    public Optional<String> getAthleteName() {
        return Optional.ofNullable(athleteName);
    }

    @Override
    public Optional<String> getAthletePreName() {
        return Optional.ofNullable(athletePreName);
    }

    @Override
    public Optional<LocalDate> getAthleteBirthday() {
        return Optional.ofNullable(athleteBirthday);
    }

    @Override
    public Optional<Gender> getAthleteGender() {
        return Optional.ofNullable(athleteGender);
    }
}
