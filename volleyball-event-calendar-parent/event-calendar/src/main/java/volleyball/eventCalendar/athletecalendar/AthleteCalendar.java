package volleyball.eventCalendar.athletecalendar;

import com.google.common.collect.Lists;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import volleyball.eventCalendar.IEventCalendar;
import volleyball.model.athlete.Athlete;
import volleyball.model.match.Match;
import volleyball.model.team.Team;
import volleyball.repository.Repository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Slf4j
public class AthleteCalendar implements IEventCalendar {

    @NonNull
    @Getter
    @EqualsAndHashCode.Exclude
    private Athlete athlete;

    @Getter
    @EqualsAndHashCode.Exclude
    @Singular("team")
    private List<Team> teamList = Lists.newArrayList();
}
