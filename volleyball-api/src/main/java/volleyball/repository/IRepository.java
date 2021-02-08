package volleyball.repository;

import volleyball.model.association.Association;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.match.Match;
import volleyball.model.result.Result;
import volleyball.model.season.Season;
import volleyball.model.team.Team;

import java.util.List;
import java.util.Optional;

public interface IRepository {

    /**
     * @param association - the association object to save
     * @return the saved {@link Association} object
     */
    Optional<Association> saveAssociationObject(Association association);

    /**
     * @return a list with {@link Association} objects
     */
    List<Association> getAssociationObjects();

    /**
     * @param season - the season object to save
     * @return the saved {@link Season} object
     */
    Optional<Season> saveSeasonObject(Season season);

    /**
     * @return a list with {@link Season} objects
     */
    List<Season> getSeasonObjects();

    /**
     * @param competition - the competition object to save
     * @return the saved {@link Competition} object
     */
    Optional<Competition> saveCompetitionObject(Competition competition);

    /**
     * @return a list with {@link Competition} objects
     */
    List<Competition> getCompetitionObjects();

    /**
     * @param match - the match object to save
     * @return the saved {@link Match} object
     */
    Optional<Match> saveMatchObject(Match match);

    /**
     * @return a list with {@link Match} objects
     */
    List<Match> getMatchObjects();

    /**
     * @param result - the result object to save
     * @return the saved {@link Result} object
     */
    Optional<Result> saveResultObject(Result result);

    /**
     * @return a list with {@link Result} objects
     */
    List<Result> getResultObjects();

    /**
     * @param club - the club object to save
     * @return the saved {@link Result} object
     */
    Optional<Club> saveClubObject(Club club);

    /**
     * @return a list with {@link Club} objects
     */
    List<Club> getClubObjects();

    /**
     * @param team - the team object to save
     * @return the saved {@link Team} object
     */
    Optional<Team> saveTeamObject(Team team);

    /**
     * @return a list with {@link Team} objects
     */
    List<Team> getTeamObjects();
}
