package volleyball.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import volleyball.model.association.Association;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.match.Match;
import volleyball.model.member.Member;
import volleyball.model.result.Result;
import volleyball.model.season.Season;
import volleyball.model.team.Team;
import volleyball.repository.Repository;
import volleyball.tools.parser.IParserResult;

import java.util.Optional;
import java.util.function.Predicate;

@Component
@Slf4j
public class Factory implements IModelFactory {

    @Autowired
    Repository repositoryManager;

    /**
     * test if the {@link IParserResult} contains the association name
     */
    protected Predicate<IParserResult> isAssociationNamePresent = data -> data.getAssociationName().isPresent();

    /**
     * test if the {@link IParserResult} contains the season period
     */
    protected Predicate<IParserResult> isSeasonPeriodPresent = data -> data.getSeasonStartYear().isPresent() && data.getSeasonEndYear().isPresent();

    /**
     * test if the {@link IParserResult} contains the season period after the year 2000
     */
    protected Predicate<IParserResult> isSeasonPeriodAfterYear2000 = data -> data.getSeasonStartYear().get() >= 2000 && data.getSeasonEndYear().get() >= 2000;

    /**
     * test if the {@link IParserResult} contains the season period in right order - start year is before end year
     */
    protected Predicate<IParserResult> isSeasonPeriodInRightOrder = data -> data.getSeasonStartYear().get() < data.getSeasonEndYear().get();

    /**
     * test if the {@link IParserResult} contains the season perdiod in correct length
     */
    protected Predicate<IParserResult> isSeasonPeriodLengthRight = data -> data.getSeasonEndYear().get() - data.getSeasonStartYear().get() == 1;

    /**
     * test if the {@link IParserResult} contains the competition name
     */
    protected Predicate<IParserResult> isCompetitionNamePresent = data -> data.getCompetitionName().isPresent();

    /**
     * test if the {@link IParserResult} contains the sets of first and second team
     */
    protected Predicate<IParserResult> isResultPresent = data -> data.getSetsTeam1().isPresent() && data.getSetsTeam2().isPresent();

    /**
     * test if the {@link IParserResult} contains the result sets in range [0,3]
     */
    protected Predicate<IParserResult> isResultSetInRange = data -> (data.getSetsTeam1().get() >= 0 && data.getSetsTeam1().get() <= 3) &&
            (data.getSetsTeam2().get() >= 0 && data.getSetsTeam2().get() <= 3);

    /**
     * test if the {@link IParserResult} contains the result with equal sets
     */
    protected Predicate<IParserResult> isResultSetEqual = data -> data.getSetsTeam1().get() == data.getSetsTeam2().get();

    /**
     * test if the {@link IParserResult} contains the result with equal zero sets
     */
    protected Predicate<IParserResult> isResultSetsEqualZero = data -> data.getSetsTeam1().get() == 0 && data.getSetsTeam2().get() == 0;

    /**
     * test if the {@link IParserResult} contains the match date time
     */
    protected Predicate<IParserResult> isMatchDateTimePresent = data -> data.getMatchDateTime().isPresent();

    /**
     * test if the {@link IParserResult} contains the match number
     */
    protected Predicate<IParserResult> isMatchNumberPresent = data -> data.getMatchNumber().isPresent();

    /**
     * test if the {@link IParserResult} contains the first club name
     */
    protected Predicate<IParserResult> isFirstClubNamePresent = data -> data.getClub1Name().isPresent();

    /**
     * test if the {@link IParserResult} contains the first team name
     */
    protected Predicate<IParserResult> isFirstTeamNamePresent = data -> data.getTeam1Name().isPresent();

    /**
     * test if the {@link IParserResult} contains the second club name
     */
    protected Predicate<IParserResult> isSecondClubNamePresent = data -> data.getClub2Name().isPresent();

    /**
     * test if the {@link IParserResult} contains the second team name
     */
    protected Predicate<IParserResult> isSecondTeamNamePresent = data -> data.getTeam2Name().isPresent();

    @Override
    public Optional<Match> buildAndSaveMatchObject(IParserResult parserResult) {
        if (parserResult == null) {
            log.error("the required parser data can't be NULL -  so return an empty object");
            return Optional.empty();
        }

        if (!isMatchDateTimePresent.test(parserResult)) {
            log.error("the required match date time can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Optional<Team> team1 = buildAndSaveTeam1Object(parserResult);
        if (!team1.isPresent()) {
            log.error("the first team is required and can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Optional<Team> team2 = buildAndSaveTeam2Object(parserResult);
        if (!team2.isPresent()) {
            log.error("the second team is required and can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Match match = Match.builder()
                .withDateTime(parserResult.getMatchDateTime().get())
                .withTeam1(team1.get())
                .withTeam2(team2.get())
                .withNumber(parserResult.getMatchNumber().orElse(""))
                .withResult(buildAndSaveResult(parserResult).orElse(null))
                .build();
        log.info("build match : {}", match);

        return repositoryManager.saveMatchObject(match);

    }

    /**
     * build and save a {@link Association} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Association} object or an empty object
     */
    protected Optional<Association> buildAndSaveAssociationObject(IParserResult parserResult) {
        if (!isAssociationNamePresent.test(parserResult)) {
            log.error("the required association name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Association association = Association.builder()
                .withName(parserResult.getAssociationName().get())
                .build();
        log.info("build association : {}", association);

        return repositoryManager.saveAssociationObject(association);
    }

    /**
     * build and save a {@link Season} object
     *
     * @param parserResult the parsed data
     * @return the saved {@link Season} object or an empty object
     */
    protected Optional<Season> buildAndSaveSeasonObject(IParserResult parserResult) {
        if (!isSeasonPeriodPresent.test(parserResult)) {
            log.error("the required season period can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodAfterYear2000.test(parserResult)) {
            log.error("the required season period can't be before year 2000 -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodInRightOrder.test(parserResult)) {
            log.error("the required season period has a wrong order -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodLengthRight.test(parserResult)) {
            log.error("the required season period has a wrong length -  so return an empty object");
            return Optional.empty();
        }

        Season season = Season.builder()
                .withStartYear(parserResult.getSeasonStartYear().get())
                .withEndYear(parserResult.getSeasonEndYear().get())
                .withAssociation(buildAndSaveAssociationObject(parserResult).orElse(null))
                .build();
        log.info("build season : {}", season);

        return repositoryManager.saveSeasonObject(season);
    }

    /**
     * build and save a {@link Competition} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Competition} object or an empty object
     */
    protected Optional<Competition> buildAndSaveCompetitionObject(IParserResult parserResult) {
        if (!isCompetitionNamePresent.test(parserResult)) {
            log.error("the required competition name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Competition competition = Competition.builder()
                .withName(parserResult.getCompetitionName().get())
                .withSeason(buildAndSaveSeasonObject(parserResult).orElse(null))
                .build();
        log.info("build competition : {}", competition);

        return repositoryManager.saveCompetitionObject(competition);
    }

    /**
     * build and save a {@link Result} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Result} object or an empty object
     */
    protected Optional<Result> buildAndSaveResult(IParserResult parserResult) {
        if (!isResultPresent.test(parserResult)) {
            log.error("the required result can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isResultSetInRange.test(parserResult)) {
            log.error("the required result set are not in range [0,3] -  so return an empty object");
            return Optional.empty();
        }

        if (!isResultSetsEqualZero.test(parserResult) && isResultSetEqual.test(parserResult)) {
            log.error("the required result set can't be equal - so return an empty object");
            return Optional.empty();
        }

        Result result = Result.builder()
                .withSetsTeam1(parserResult.getSetsTeam1().get())
                .withSetsTeam2(parserResult.getSetsTeam2().get())
                .build();
        log.info("build result : {}", result);

        return repositoryManager.saveResultObject(result);
    }

    /**
     * build and save a {@link Club} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Club} object or an empty object
     */
    protected Optional<Club> buildAndSaveClub1Object(IParserResult parserResult) {
        if (!isFirstClubNamePresent.test(parserResult)) {
            log.error("the required club name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Club club = Club.builder()
                .withName(parserResult.getClub1Name().get())
                .build();
        log.info("build club : {}", club);

        return repositoryManager.saveClubObject(club);
    }

    /**
     * build and save a {@link Team} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Team} object or an empty object
     */
    protected Optional<Team> buildAndSaveTeam1Object(IParserResult parserResult) {
        if (!isFirstTeamNamePresent.test(parserResult)) {
            log.error("the required team name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Team team = Team.builder()
                .withName(parserResult.getTeam1Name().get())
                .withClub(buildAndSaveClub1Object(parserResult).orElse(null))
                .withCompetition(buildAndSaveCompetitionObject(parserResult).orElse(null))
                .build();
        log.info("build first team : {}", team);

        return repositoryManager.saveTeamObject(team);
    }

    /**
     * build and save a {@link Club} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Club} object or an empty object
     */
    protected Optional<Club> buildAndSaveClub2Object(IParserResult parserResult) {
        if (!isSecondClubNamePresent.test(parserResult)) {
            log.error("the required club name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Club club = Club.builder()
                .withName(parserResult.getClub2Name().get())
                .build();
        log.info("build club : {}", club);

        return repositoryManager.saveClubObject(club);
    }

    /**
     * build and save a {@link Team} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Team} object or an empty object
     */
    protected Optional<Team> buildAndSaveTeam2Object(IParserResult parserResult) {
        if (!isSecondTeamNamePresent.test(parserResult)) {
            log.error("the required team name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Team team = Team.builder()
                .withName(parserResult.getTeam2Name().get())
                .withClub(buildAndSaveClub2Object(parserResult).orElse(null))
                .withCompetition(buildAndSaveCompetitionObject(parserResult).orElse(null))
                .build();
        log.info("build team : {}", team);

        return repositoryManager.saveTeamObject(team);
    }

    @Override
    public Optional<Member> buildAndSaveMemberObject(IParserResult parserResult) {
        return Optional.empty();
    }
}
