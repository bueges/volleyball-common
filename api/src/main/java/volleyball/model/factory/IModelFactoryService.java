package volleyball.model.factory;

import volleyball.model.builder.association.Association;
import volleyball.model.builder.club.Club;
import volleyball.model.builder.competition.Competition;
import volleyball.model.builder.match.Match;
import volleyball.model.builder.result.Result;
import volleyball.model.builder.season.Season;
import volleyball.model.builder.team.Team;
import volleyball.importer.importerData.IImportedData;

import java.util.Optional;

public interface IModelFactoryService {

    /**
     * build and save a {@link Association} object
     *
     * @param data the imported data
     * @return the saved association or an empty object
     */
    Optional<Association> buildAndSaveAssociation(IImportedData data);

    /**
     * build and save a {@link Season} object
     *
     * @param data the imported data
     * @return the saved season or an empty object
     */
    Optional<Season> buildAndSaveSeason(IImportedData data);

    /**
     * build and save a {@link Competition} object
     *
     * @param data the imported data
     * @return the saved competition or an empty object
     */
    Optional<Competition> buildAndSaveCompetition(IImportedData data);

    /**
     * build and save a {@link Match} object
     *
     * @param data the imported data
     * @return the saved match or an empty object
     */
    Optional<Match> buildAndSaveMatch(IImportedData data);

    /**
     * build and save a {@link Result} object
     *
     * @param data the imported data
     * @return the saved result or an empty object
     */
    Optional<Result> buildAndSaveResult(IImportedData data);

    /**
     * build and save a {@link Club} object
     *
     * @param data the imported data
     * @return the saved first club or an empty object
     */
    Optional<Club> buildAndSaveClub1(IImportedData data);

    /**
     * build and save a {@link Team} object
     *
     * @param data the imported data
     * @return the saved first team or an empty object
     */
    Optional<Team> buildAndSaveTeam1(IImportedData data);

    /**
     * build and save a {@link Club} object
     *
     * @param data the imported data
     * @return the saved second club or an empty object
     */
    Optional<Club> buildAndSaveClub2(IImportedData data);

    /**
     * build and save a {@link Team} object
     *
     * @param data the imported data
     * @return the saved second team or an empty object
     */
    Optional<Team> buildAndSaveTeam2(IImportedData data);
}
