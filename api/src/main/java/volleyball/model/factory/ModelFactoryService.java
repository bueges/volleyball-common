package volleyball.model.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import volleyball.model.builder.association.Association;
import volleyball.model.builder.association.AssociationBuilder;
import volleyball.model.builder.club.Club;
import volleyball.model.builder.club.ClubBuilder;
import volleyball.model.builder.competition.Competition;
import volleyball.model.builder.competition.CompetitionBuilder;
import volleyball.model.builder.match.Match;
import volleyball.model.builder.match.MatchBuilder;
import volleyball.model.builder.result.Result;
import volleyball.model.builder.result.ResultBuilder;
import volleyball.model.builder.season.Season;
import volleyball.model.builder.season.SeasonBuilder;
import volleyball.model.builder.team.Team;
import volleyball.model.builder.team.TeamBuilder;
import volleyball.importer.importerData.IImportedData;
import volleyball.model.repository.RepositoryService;

import java.util.List;
import java.util.Optional;

public abstract class ModelFactoryService implements IModelFactoryService {

    private static final Logger logger = LogManager.getLogger(ModelFactoryService.class);

    @Autowired
    RepositoryService repositoryService;

    protected AssociationBuilder associationBuilder;
    protected SeasonBuilder seasonBuilder;
    protected CompetitionBuilder competitionBuilder;
    protected ResultBuilder resultBuilder;
    protected MatchBuilder matchBuilder;
    protected ClubBuilder clubBuilder;
    protected TeamBuilder teamBuilder;

    /**
     * init the service and set the builder
     */
    public abstract void init();

    /**
     * build and save model objects from imported data
     *
     * @param dataList the imported data
     */
    public void buildAndSaveModelObjectsFromImportedData(List<IImportedData> dataList) {
        for (IImportedData data : dataList) {
            buildAndSaveMatch(data);
        }
    }

    @Override
    public Optional<Association> buildAndSaveAssociation(IImportedData data) {
        Optional<Association> association = Optional.empty();

        if (associationBuilder != null) {
            association = associationBuilder
                    .withName(data.getAssociationName().orElse(""))
                    .build();
            logger.debug("build association : {}", association);

            association = repositoryService.saveAssociation(association);
            logger.debug("save association : {}", association);
        }

        logger.info("build and save association : {}", association);
        return association;
    }

    @Override
    public Optional<Season> buildAndSaveSeason(IImportedData data) {
        Optional<Season> season = Optional.empty();

        if (seasonBuilder != null) {
            season = seasonBuilder
                    .withStartYear(data.getSeasonStartYear().orElse(-1))
                    .withEndYear(data.getSeasonEndYear().orElse(-1))
                    .withAssociation(buildAndSaveAssociation(data).orElse(null))
                    .build();
            logger.debug("build season : {}", season);

            season = repositoryService.saveSeason(season);
            logger.debug("save season : {}", season);
        }

        logger.info("build and save season : {}", season);
        return season;
    }

    @Override
    public Optional<Competition> buildAndSaveCompetition(IImportedData data) {
        Optional<Competition> competition = Optional.empty();

        if (competitionBuilder != null) {
            competition = competitionBuilder
                    .withName(data.getCompetitionName().orElse(""))
                    .withSeason(buildAndSaveSeason(data).orElse(null))
                    .build();
            logger.debug("build competition : {}", competition);

            competition = repositoryService.saveCompetition(competition);
            logger.debug("save competition : {}", competition);
        }

        logger.debug("build and save competition : {}", competition);
        return competition;
    }

    @Override
    public Optional<Match> buildAndSaveMatch(IImportedData data) {
        Optional<Match> match = Optional.empty();

        if (matchBuilder != null) {
            match = matchBuilder
                    .withDateTime(data.getMatchDateTime().orElse(null))
                    .withNumber(data.getMatchNumber().orElse(""))
                    .withTeam1(buildAndSaveTeam1(data).orElse(null))
                    .withTeam2(buildAndSaveTeam2(data).orElse(null))
                    .withResult(buildAndSaveResult(data).orElse(null))
                    .build();
            logger.debug("build match : {}", match);

            match = repositoryService.saveMatch(match);
            logger.debug("save match : {}", match);
        }

        logger.info("build and save match : {}", match);
        return match;
    }

    @Override
    public Optional<Result> buildAndSaveResult(IImportedData data) {
        Optional<Result> result = Optional.empty();

        if (resultBuilder != null) {
            result = resultBuilder
                    .withSetsTeam1(data.getSetsTeam1().orElse(-1))
                    .withSetsTeam2(data.getSetsTeam2().orElse(-1))
                    .build();
            logger.debug("build result : {}", result);

            result = repositoryService.saveResult(result);
            logger.debug("save result : {}", result);
        }

        logger.info("build and save result : {}", result);
        return result;
    }

    @Override
    public Optional<Club> buildAndSaveClub1(IImportedData data) {
        Optional<Club> club = Optional.empty();

        if (clubBuilder != null) {
            club = clubBuilder
                    .withName(data.getClub1Name().orElse(""))
                    .build();
            logger.debug("build club : {}", club);

            club = repositoryService.saveClub(club);
            logger.debug("save club : {}", club);
        }

        logger.info("build and save club : {}", club);
        return club;
    }

    @Override
    public Optional<Team> buildAndSaveTeam1(IImportedData data) {
        Optional<Team> team = Optional.empty();

        if (teamBuilder != null) {
            team = teamBuilder
                    .withName(data.getTeam1Name().orElse(""))
                    .withClub(buildAndSaveClub1(data).orElse(null))
                    .withCompetition(buildAndSaveCompetition(data).orElse(null))
                    .build();
            logger.debug("build team : {}", team);

            team = repositoryService.saveTeam(team);
            logger.debug("save team : {}", team);
        }

        logger.info("build and save team : {}", team);
        return team;
    }

    @Override
    public Optional<Club> buildAndSaveClub2(IImportedData data) {
        Optional<Club> club = Optional.empty();

        if (clubBuilder != null) {
            club = clubBuilder
                    .withName(data.getClub2Name().orElse(""))
                    .build();
            logger.debug("build club : {}", club);

            club = repositoryService.saveClub(club);
            logger.debug("save club : {}", club);
        }

        logger.info("build and save club : {}", club);
        return club;
    }

    @Override
    public Optional<Team> buildAndSaveTeam2(IImportedData data) {
        Optional<Team> team = Optional.empty();

        if (teamBuilder != null) {
            team = teamBuilder
                    .withName(data.getTeam2Name().orElse(""))
                    .withClub(buildAndSaveClub2(data).orElse(null))
                    .withCompetition(buildAndSaveCompetition(data).orElse(null))
                    .build();
            logger.debug("build team : {}", team);

            team = repositoryService.saveTeam(team);
            logger.debug("save team : {}", team);
        }

        logger.info("build and save team : {}", team);
        return team;
    }
}
