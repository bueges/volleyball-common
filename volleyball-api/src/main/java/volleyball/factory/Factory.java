package volleyball.factory;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import volleyball.model.association.Association;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.match.Match;
import volleyball.model.athlete.Athlete;
import volleyball.model.result.Result;
import volleyball.model.season.Season;
import volleyball.model.team.Team;
import volleyball.modelData.athleteData.IAthleteData;
import volleyball.repository.Repository;
import volleyball.modelData.eventData.IEventData;
import volleyball.tools.parser.IParser;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
@Slf4j
public class Factory implements IModelFactory {

    @Autowired
    Repository repository;

    /**
     * test if the {@link IEventData} contains the association name
     */
    protected Predicate<IEventData> isAssociationNamePresent = data -> data.getAssociationName().isPresent();

    /**
     * test if the {@link IEventData} contains the season period
     */
    protected Predicate<IEventData> isSeasonPeriodPresent = data -> data.getSeasonStartYear().isPresent() && data.getSeasonEndYear().isPresent();

    /**
     * test if the {@link IEventData} contains the season period after the year 2000
     */
    protected Predicate<IEventData> isSeasonPeriodAfterYear2000 = data -> data.getSeasonStartYear().get() >= 2000 && data.getSeasonEndYear().get() >= 2000;

    /**
     * test if the {@link IEventData} contains the season period in right order - start year is before end year
     */
    protected Predicate<IEventData> isSeasonPeriodInRightOrder = data -> data.getSeasonStartYear().get() < data.getSeasonEndYear().get();

    /**
     * test if the {@link IEventData} contains the season perdiod in correct length
     */
    protected Predicate<IEventData> isSeasonPeriodLengthRight = data -> data.getSeasonEndYear().get() - data.getSeasonStartYear().get() == 1;

    /**
     * test if the {@link IEventData} contains the competition name
     */
    protected Predicate<IEventData> isCompetitionNamePresent = data -> data.getCompetitionName().isPresent();

    /**
     * test if the {@link IEventData} contains the sets of first and second team
     */
    protected Predicate<IEventData> isResultPresent = data -> data.getSetsTeam1().isPresent() && data.getSetsTeam2().isPresent();

    /**
     * test if the {@link IEventData} contains the result sets in range [0,3]
     */
    protected Predicate<IEventData> isResultSetInRange = data -> (data.getSetsTeam1().get() >= 0 && data.getSetsTeam1().get() <= 3) &&
            (data.getSetsTeam2().get() >= 0 && data.getSetsTeam2().get() <= 3);

    /**
     * test if the {@link IEventData} contains the result with equal sets
     */
    protected Predicate<IEventData> isResultSetEqual = data -> data.getSetsTeam1().get() == data.getSetsTeam2().get();

    /**
     * test if the {@link IEventData} contains the result with equal zero sets
     */
    protected Predicate<IEventData> isResultSetsEqualZero = data -> data.getSetsTeam1().get() == 0 && data.getSetsTeam2().get() == 0;

    /**
     * test if the {@link IEventData} contains the match date time
     */
    protected Predicate<IEventData> isMatchDateTimePresent = data -> data.getMatchDateTime().isPresent();

    /**
     * test if the {@link IEventData} contains the match number
     */
    protected Predicate<IEventData> isMatchNumberPresent = data -> data.getMatchNumber().isPresent();

    /**
     * test if the {@link IEventData} contains the first club name
     */
    protected Predicate<IEventData> isFirstClubNamePresent = data -> data.getClub1Name().isPresent();

    /**
     * test if the {@link IEventData} contains the first team name
     */
    protected Predicate<IEventData> isFirstTeamNamePresent = data -> data.getTeam1Name().isPresent();

    /**
     * test if the {@link IEventData} contains the second club name
     */
    protected Predicate<IEventData> isSecondClubNamePresent = data -> data.getClub2Name().isPresent();

    /**
     * test if the {@link IEventData} contains the second team name
     */
    protected Predicate<IEventData> isSecondTeamNamePresent = data -> data.getTeam2Name().isPresent();

    @Override
    public List<Match> parseDataAndSaveObjects(IParser parser) {
        List<IEventData> eventDataList = parser.parseFile();
        List<Match> matchList = Lists.newLinkedList();

        eventDataList.forEach(eventData -> {
            Optional<Match> savedMatch = buildAndSaveMatchObject(eventData);
            if (savedMatch.isPresent())
                matchList.add(savedMatch.get());
        });

        return matchList;
    }

    @Override
    public Optional<Match> buildAndSaveMatchObject(IEventData eventData) {
        if (eventData == null) {
            log.error("the required parser data can't be NULL -  so return an empty object");
            return Optional.empty();
        }

        if (!isMatchDateTimePresent.test(eventData)) {
            log.error("the required match date time can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Optional<Team> team1 = buildAndSaveTeam1Object(eventData);
        if (!team1.isPresent()) {
            log.error("the first team is required and can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Optional<Team> team2 = buildAndSaveTeam2Object(eventData);
        if (!team2.isPresent()) {
            log.error("the second team is required and can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Match match = Match.builder()
                .withDateTime(eventData.getMatchDateTime().get())
                .withTeam1(team1.get())
                .withTeam2(team2.get())
                .withNumber(eventData.getMatchNumber().orElse(""))
                .withResult(buildAndSaveResult(eventData).orElse(null))
                .build();
        log.info("build match : {}", match);

        return repository.saveMatchObject(match);

    }

    /**
     * build and save a {@link Association} object
     *
     * @param eventData - the event data
     * @return the saved {@link Association} object or an empty object
     */
    protected Optional<Association> buildAndSaveAssociationObject(IEventData eventData) {
        if (!isAssociationNamePresent.test(eventData)) {
            log.error("the required association name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Association association = Association.builder()
                .withName(eventData.getAssociationName().get())
                .build();
        log.info("build association : {}", association);

        return repository.saveAssociationObject(association);
    }

    /**
     * build and save a {@link Season} object
     *
     * @param eventData the event data
     * @return the saved {@link Season} object or an empty object
     */
    protected Optional<Season> buildAndSaveSeasonObject(IEventData eventData) {
        if (!isSeasonPeriodPresent.test(eventData)) {
            log.error("the required season period can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodAfterYear2000.test(eventData)) {
            log.error("the required season period can't be before year 2000 -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodInRightOrder.test(eventData)) {
            log.error("the required season period has a wrong order -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodLengthRight.test(eventData)) {
            log.error("the required season period has a wrong length -  so return an empty object");
            return Optional.empty();
        }

        Season season = Season.builder()
                .withStartYear(eventData.getSeasonStartYear().get())
                .withEndYear(eventData.getSeasonEndYear().get())
                .withAssociation(buildAndSaveAssociationObject(eventData).orElse(null))
                .build();
        log.info("build season : {}", season);

        return repository.saveSeasonObject(season);
    }

    /**
     * build and save a {@link Competition} object
     *
     * @param eventData - the event data
     * @return the saved {@link Competition} object or an empty object
     */
    protected Optional<Competition> buildAndSaveCompetitionObject(IEventData eventData) {
        if (!isCompetitionNamePresent.test(eventData)) {
            log.error("the required competition name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Competition competition = Competition.builder()
                .withName(eventData.getCompetitionName().get())
                .withSeason(buildAndSaveSeasonObject(eventData).orElse(null))
                .build();
        log.info("build competition : {}", competition);

        return repository.saveCompetitionObject(competition);
    }

    /**
     * build and save a {@link Result} object
     *
     * @param eventData - the event data
     * @return the saved {@link Result} object or an empty object
     */
    protected Optional<Result> buildAndSaveResult(IEventData eventData) {
        if (!isResultPresent.test(eventData)) {
            log.error("the required result can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isResultSetInRange.test(eventData)) {
            log.error("the required result set are not in range [0,3] -  so return an empty object");
            return Optional.empty();
        }

        if (!isResultSetsEqualZero.test(eventData) && isResultSetEqual.test(eventData)) {
            log.error("the required result set can't be equal - so return an empty object");
            return Optional.empty();
        }

        Result result = Result.builder()
                .withSetsTeam1(eventData.getSetsTeam1().get())
                .withSetsTeam2(eventData.getSetsTeam2().get())
                .build();
        log.info("build result : {}", result);

        return repository.saveResultObject(result);
    }

    /**
     * build and save a {@link Club} object
     *
     * @param eventData - the event data
     * @return the saved {@link Club} object or an empty object
     */
    protected Optional<Club> buildAndSaveClub1Object(IEventData eventData) {
        if (!isFirstClubNamePresent.test(eventData)) {
            log.error("the required club name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Club club = Club.builder()
                .withName(eventData.getClub1Name().get())
                .build();
        log.info("build club : {}", club);

        return repository.saveClubObject(club);
    }

    /**
     * build and save a {@link Team} object
     *
     * @param eventData - the event data
     * @return the saved {@link Team} object or an empty object
     */
    protected Optional<Team> buildAndSaveTeam1Object(IEventData eventData) {
        if (!isFirstTeamNamePresent.test(eventData)) {
            log.error("the required team name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Team team = Team.builder()
                .withName(eventData.getTeam1Name().get())
                .withClub(buildAndSaveClub1Object(eventData).orElse(null))
                .withCompetition(buildAndSaveCompetitionObject(eventData).orElse(null))
                .build();
        log.info("build first team : {}", team);

        return repository.saveTeamObject(team);
    }

    /**
     * build and save a {@link Club} object
     *
     * @param eventData - the event data
     * @return the saved {@link Club} object or an empty object
     */
    protected Optional<Club> buildAndSaveClub2Object(IEventData eventData) {
        if (!isSecondClubNamePresent.test(eventData)) {
            log.error("the required club name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        Club club = Club.builder()
                .withName(eventData.getClub2Name().get())
                .build();
        log.info("build club : {}", club);

        return repository.saveClubObject(club);
    }

    /**
     * build and save a {@link Team} object
     *
     * @param eventData - the event data
     * @return the saved {@link Team} object or an empty object
     */
    protected Optional<Team> buildAndSaveTeam2Object(IEventData eventData) {
        if (!isSecondTeamNamePresent.test(eventData)) {
            log.error("the required team name can't be empty - so return an empty object");
            return Optional.empty();
        }

        Team team = Team.builder()
                .withName(eventData.getTeam2Name().get())
                .withClub(buildAndSaveClub2Object(eventData).orElse(null))
                .withCompetition(buildAndSaveCompetitionObject(eventData).orElse(null))
                .build();
        log.info("build team : {}", team);

        return repository.saveTeamObject(team);
    }

    @Override
    public Optional<Athlete> buildAndSaveAthleteObject(IAthleteData athleteData) {
        Athlete athlete = Athlete.builder()
                .withName(athleteData.getAthleteName().orElse(""))
                .withPreName(athleteData.getAthletePreName().orElse(""))
                .withBirthday(athleteData.getAthleteBirthday().get())
                .withGender(athleteData.getAthleteGender().get())
                .build();

        log.info("build athlete : {}", athlete);

        return repository.saveAthleteObject(athlete);
    }
}
