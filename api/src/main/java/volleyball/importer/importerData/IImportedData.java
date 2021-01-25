package volleyball.importer.importerData;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IImportedData {

    /**
     * @return the imported association name
     */
    Optional<String> getAssociationName();

    /**
     * @return the imported season start year
     */
    Optional<Integer> getSeasonStartYear();

    /**
     * @return the imported season end year
     */
    Optional<Integer> getSeasonEndYear();

    /**
     * @return the imported competition name
     */
    Optional<String> getCompetitionName();

    /**
     * @return the imported match date time
     */
    Optional<LocalDateTime> getMatchDateTime();

    /**
     * @return the imported match number
     */
    Optional<String> getMatchNumber();

    /**
     * @return the imported sets of first team
     */
    Optional<Integer> getSetsTeam1();

    /**
     * @return the imported sets of second team
     */
    Optional<Integer> getSetsTeam2();

    /**
     * @return the imported club1 name
     */
    Optional<String> getClub1Name();

    /**
     * @return the imported team1 name
     */
    Optional<String> getTeam1Name();

    /**
     * @return the imported club2 name
     */
    Optional<String> getClub2Name();

    /**
     * @return the imported team2 name
     */
    Optional<String> getTeam2Name();
}
