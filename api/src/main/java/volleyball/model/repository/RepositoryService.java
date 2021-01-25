package volleyball.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volleyball.model.builder.association.Association;
import volleyball.model.builder.club.Club;
import volleyball.model.builder.competition.Competition;
import volleyball.model.builder.match.Match;
import volleyball.model.builder.result.Result;
import volleyball.model.builder.season.Season;
import volleyball.model.builder.team.Team;
import volleyball.model.repository.association.AssociationRepository;
import volleyball.model.repository.club.ClubRepository;
import volleyball.model.repository.competition.CompetitionRepository;
import volleyball.model.repository.match.MatchRepository;
import volleyball.model.repository.result.ResultRepository;
import volleyball.model.repository.season.SeasonRepository;
import volleyball.model.repository.team.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryService implements IRepositoryService {

    @Autowired
    AssociationRepository associationRepository;
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    CompetitionRepository competitionRepository;
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    public Optional<Association> saveAssociation(Optional<Association> association) {
        if (association.isPresent()) {
            return Optional.of(associationRepository.saveObject(association.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Association> getAssociationList() {
        return associationRepository.findAll();
    }

    @Override
    public Optional<Season> saveSeason(Optional<Season> season) {
        if (season.isPresent()) {
            return Optional.of(seasonRepository.saveObject(season.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Season> getSeasonList() {
        return seasonRepository.findAll();
    }

    @Override
    public Optional<Competition> saveCompetition(Optional<Competition> competition) {
        if (competition.isPresent()) {
            return Optional.of(competitionRepository.saveObject(competition.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Competition> getCompetitionList() {
        return competitionRepository.findAll();
    }

    @Override
    public Optional<Result> saveResult(Optional<Result> result) {
        if (result.isPresent()) {
            return Optional.of(resultRepository.saveObject(result.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Result> getResultList() {
        return resultRepository.findAll();
    }

    @Override
    public Optional<Match> saveMatch(Optional<Match> match) {
        if (match.isPresent()) {
            return Optional.of(matchRepository.saveObject(match.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Match> getMatchList() {
        return matchRepository.findAll();
    }

    @Override
    public Optional<Club> saveClub(Optional<Club> club) {
        if (club.isPresent()) {
            return Optional.of(clubRepository.saveObject(club.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Club> getClubList() {
        return clubRepository.findAll();
    }

    @Override
    public Optional<Team> saveTeam(Optional<Team> team) {
        if (team.isPresent()) {
            return Optional.of(teamRepository.saveObject(team.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Team> getTeamList() {
        return teamRepository.findAll();
    }
}
