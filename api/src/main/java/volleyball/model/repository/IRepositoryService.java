package volleyball.model.repository;

import volleyball.model.builder.association.Association;
import volleyball.model.builder.club.Club;
import volleyball.model.builder.competition.Competition;
import volleyball.model.builder.match.Match;
import volleyball.model.builder.result.Result;
import volleyball.model.builder.season.Season;
import volleyball.model.builder.team.Team;

import java.util.List;
import java.util.Optional;

public interface IRepositoryService {

    /**
     * @param association the association to save
     * @return the saved object or an empty object
     */
    Optional<Association> saveAssociation(Optional<Association> association);

    /**
     * @return the association list
     */
    List<Association> getAssociationList();

    /**
     * @param season the season to save
     * @return the saved object or an empty object
     */
    Optional<Season> saveSeason(Optional<Season> season);

    /**
     * @return the season list
     */
    List<Season> getSeasonList();

    /**
     * @param competition the competition to save
     * @return the saved object or an empty object
     */
    Optional<Competition> saveCompetition(Optional<Competition> competition);

    /**
     * @return the competition list
     */
    List<Competition> getCompetitionList();

    /**
     * @param result the result to save
     * @return the saved object or an empty object
     */
    Optional<Result> saveResult(Optional<Result> result);

    /**
     * @return the result list
     */
    List<Result> getResultList();

    /**
     * @param match the match to save
     * @return the saved object or an empty object
     */
    Optional<Match> saveMatch(Optional<Match> match);

    /**
     * @return the match list
     */
    List<Match> getMatchList();

    /**
     * @param club the club to save
     * @return the saved object or an empty object
     */
    Optional<Club> saveClub(Optional<Club> club);

    /**
     * @return the club list
     */
    List<Club> getClubList();

    /**
     * @param team the team to save
     * @return the saved object or an empty object
     */
    Optional<Team> saveTeam(Optional<Team> team);

    /**
     * @return the team list
     */
    List<Team> getTeamList();
}
