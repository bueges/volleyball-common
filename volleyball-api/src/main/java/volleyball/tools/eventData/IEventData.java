package volleyball.tools.eventData;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;

public interface IEventData {

    /**
     * @return the parsed association name or an empty object
     */
    Optional<String> getAssociationName();

    /**
     * @return the parsed season start year or an empty object
     */
    Optional<Integer> getSeasonStartYear();

    /**
     * @return the parsed season end year or an empty object
     */
    Optional<Integer> getSeasonEndYear();

    /**
     * test if the parser result contains all required season data
     */
    Predicate<IEventData> hasRequiredSeasonData = data -> data.getSeasonStartYear().isPresent();

    /**
     * @return the parsed competition name or an empty object
     */
    Optional<String> getCompetitionName();

    /**
     * @return the parsed match date time or an empty object
     */
    Optional<LocalDateTime> getMatchDateTime();

    /**
     * @return the parsed match number or an empty object
     */
    Optional<String> getMatchNumber();

    /**
     * @return the parsed sets of first team or an empty object
     */
    Optional<Integer> getSetsTeam1();

    /**
     * @return the parsed sets of second team or an empty object
     */
    Optional<Integer> getSetsTeam2();

    /**
     * @return the parsed club1 name or an empty object
     */
    Optional<String> getClub1Name();

    /**
     * @return the parsed team1 name or an empty object
     */
    Optional<String> getTeam1Name();

    /**
     * @return the parsed club2 name or an empty object
     */
    Optional<String> getClub2Name();

    /**
     * @return the parsed team2 name or an empty object
     */
    Optional<String> getTeam2Name();
}
