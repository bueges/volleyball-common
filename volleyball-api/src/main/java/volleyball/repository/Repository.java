package volleyball.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import volleyball.model.association.Association;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.event.Event;
import volleyball.model.match.Match;
import volleyball.model.result.Result;
import volleyball.model.season.Season;
import volleyball.model.team.Team;
import volleyball.repository.association.IAssociationRepository;
import volleyball.repository.club.IClubRepository;
import volleyball.repository.competition.ICompetitionRepository;
import volleyball.repository.event.IEventRepository;
import volleyball.repository.match.IMatchRepository;
import volleyball.repository.athlete.IAthleteRepository;
import volleyball.repository.result.IResultRepository;
import volleyball.repository.season.ISeasonRepository;
import volleyball.repository.team.ITeamRepository;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class Repository implements IRepository {

    @Autowired
    IAssociationRepository associationRepository;

    @Autowired
    ISeasonRepository seasonRepository;

    @Autowired
    ICompetitionRepository competitionRepository;

    @Autowired
    IMatchRepository matchRepository;

    @Autowired
    IResultRepository resultRepository;

    @Autowired
    IClubRepository clubRepository;

    @Autowired
    ITeamRepository teamRepository;

    @Autowired
    IAthleteRepository memberRepository;

    @Autowired
    IEventRepository eventRepository;

    @Override
    public Optional<Association> saveAssociationObject(Association association) {
        if (association == null) {
            log.error("association object is NULL - so return empty object.");
            return Optional.empty();
        }

        Association savedAssociation = associationRepository.saveObject(association);
        log.info("saved association object : {}", savedAssociation);
        return Optional.ofNullable(savedAssociation);
    }

    @Override
    public List<Association> getAssociationObjects() {
        return associationRepository.findAll();
    }

    @Override
    public Optional<Season> saveSeasonObject(Season season) {
        if (season == null) {
            log.error("season object is NULL - so return empty object.");
            return Optional.empty();
        }

        Season savedSeason = seasonRepository.saveObject(season);
        log.info("saved season object : {}", savedSeason);
        return Optional.ofNullable(savedSeason);
    }

    @Override
    public List<Season> getSeasonObjects() {
        return seasonRepository.findAll();
    }

    @Override
    public Optional<Competition> saveCompetitionObject(Competition competition) {
        if (competition == null) {
            log.error("competition object is NULL - so return empty object.");
            return Optional.empty();
        }

        Competition savedCompetition = competitionRepository.saveObject(competition);
        log.info("saved competition object : {}", savedCompetition);
        return Optional.ofNullable(savedCompetition);
    }

    @Override
    public List<Competition> getCompetitionObjects() {
        return competitionRepository.findAll();
    }

    @Override
    public Optional<Match> saveMatchObject(Match match) {
        if (match == null) {
            log.error("match object is NULL - so return empty object.");
            return Optional.empty();
        }

        Match savedMatch = matchRepository.saveObject(match);
        log.info("saved match object : {}", savedMatch);
        return Optional.ofNullable(savedMatch);
    }

    @Override
    public List<Match> getMatchObjects() {
        return matchRepository.findAll();
    }

    @Override
    public Optional<Result> saveResultObject(Result result) {
        if (result == null) {
            log.error("result object is NULL - so return empty object.");
            return Optional.empty();
        }

        Result savedResult = resultRepository.saveObject(result);
        log.info("saved result object : {}", savedResult);
        return Optional.ofNullable(savedResult);
    }

    @Override
    public List<Result> getResultObjects() {
        return resultRepository.findAll();
    }

    @Override
    public Optional<Club> saveClubObject(Club club) {
        if (club == null) {
            log.error("club object is NULL - so return empty object.");
            return Optional.empty();
        }

        Club savedClub = clubRepository.saveObject(club);
        log.info("saved club object : {}", savedClub);
        return Optional.ofNullable(savedClub);
    }

    @Override
    public List<Club> getClubObjects() {
        return clubRepository.findAll();
    }

    @Override
    public Optional<Team> saveTeamObject(Team team) {
        if (team == null) {
            log.error("team object is NULL - so return empty object.");
            return Optional.empty();
        }

        Team savedTeam = teamRepository.saveObject(team);
        log.info("saved team object : {}", savedTeam);
        return Optional.ofNullable(savedTeam);
    }

    @Override
    public List<Team> getTeamObjects() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Event> saveEventObject(Event event) {
        if (event == null) {
            log.error("event object is NULL - so return empty object.");
            return Optional.empty();
        }

        Event savedEvent = eventRepository.saveObject(event);
        log.info("saved event object : {}", savedEvent);
        return Optional.ofNullable(savedEvent);
    }

    @Override
    public List<Event> getEventObjects() {
        return eventRepository.findAll();
    }
}
