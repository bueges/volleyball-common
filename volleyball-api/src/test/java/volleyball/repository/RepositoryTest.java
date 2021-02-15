package volleyball.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.model.association.Association;
import volleyball.model.athlete.Athlete;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.event.Event;
import volleyball.model.match.Match;
import volleyball.model.result.Result;
import volleyball.model.season.Season;
import volleyball.model.team.Team;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.*;

@SpringBootTest
@Slf4j
public class RepositoryTest {

    @Autowired
    Repository manager;

    @Test
    @DisplayName("save athlete object")
    @Transactional
    public void saveAthleteObject() {
        assertEquals(0, manager.getAthleteObjects().size());

        Athlete athlete = Athlete.builder()
                .withName(ATHLETE_NAME)
                .withPreName(ATHLETE_PRENAME)
                .withBirthday(ATHLETE_BIRTHDAY)
                .withGender(ATHLETE_GENDER)
                .build();
        Optional<Athlete> savedAthlete = manager.saveAthleteObject(athlete);
        assertTrue(savedAthlete.isPresent());
        assertEquals(1, manager.getAthleteObjects().size());
        assertTrue(savedAthlete.get().getId() > 0);
    }

    @Test
    @DisplayName("save event object")
    @Transactional
    public void saveEventObject() {
        assertEquals(0, manager.getEventObjects().size());
        assertEquals(0, manager.getAssociationObjects().size());
        assertEquals(0, manager.getSeasonObjects().size());
        assertEquals(0, manager.getCompetitionObjects().size());
        assertEquals(0, manager.getResultObjects().size());
        assertEquals(0, manager.getMatchObjects().size());
        assertEquals(0, manager.getClubObjects().size());
        assertEquals(0, manager.getTeamObjects().size());

        Association association = Association.builder()
                .withName(ASSOCIATION_NAME)
                .build();
        Optional<Association> saveAssociation = manager.saveAssociationObject(association);
        assertTrue(saveAssociation.isPresent());
        assertEquals(1, manager.getAssociationObjects().size());
        assertTrue(saveAssociation.get().getId() > 0);

        Season season = Season.builder()
                .withStartYear(SEASON_START_YEAR)
                .withEndYear(SEASON_END_YEAR)
                .withAssociation(saveAssociation.get())
                .build();
        Optional<Season> savedSeason = manager.saveSeasonObject(season);
        assertTrue(savedSeason.isPresent());
        assertEquals(1, manager.getSeasonObjects().size());
        assertTrue(savedSeason.get().getId() > 0);

        Competition competition = Competition.builder()
                .withName(COMPETITION_NAME)
                .withSeason(savedSeason.get())
                .build();
        Optional<Competition> savedCompetition = manager.saveCompetitionObject(competition);
        assertTrue(savedCompetition.isPresent());
        assertEquals(1, manager.getCompetitionObjects().size());
        assertTrue(savedCompetition.get().getId() > 0);

        Club club1 = Club.builder()
                .withName(CLUB1_NAME)
                .build();
        Optional<Club> savedClub1 = manager.saveClubObject(club1);
        assertTrue(savedClub1.isPresent());
        assertEquals(1, manager.getClubObjects().size());
        assertTrue(savedClub1.get().getId() > 0);

        Team team1 = Team.builder()
                .withName(TEAM1_NAME)
                .withCompetition(savedCompetition.get())
                .withClub(savedClub1.get())
                .build();
        Optional<Team> savedTeam1 = manager.saveTeamObject(team1);
        assertTrue(savedTeam1.isPresent());
        assertEquals(1, manager.getTeamObjects().size());
        assertTrue(savedTeam1.get().getId() > 0);

        Club club2 = Club.builder()
                .withName(CLUB2_NAME)
                .build();
        Optional<Club> savedClub2 = manager.saveClubObject(club2);
        assertTrue(savedClub2.isPresent());
        assertEquals(2, manager.getClubObjects().size());
        assertTrue(savedClub2.get().getId() > 0);

        Team team2 = Team.builder()
                .withName(TEAM2_NAME)
                .withCompetition(savedCompetition.get())
                .withClub((Club) savedClub2.get())
                .build();
        Optional<Team> savedTeam2 = manager.saveTeamObject(team2);
        assertTrue(savedTeam2.isPresent());
        assertEquals(2, manager.getTeamObjects().size());
        assertTrue(savedTeam2.get().getId() > 0);

        Result result = Result.builder()
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .build();
        Optional<Result> savedResult = manager.saveResultObject(result);
        assertTrue(savedResult.isPresent());
        assertEquals(1, manager.getResultObjects().size());
        assertTrue(savedResult.get().getId() > 0);

        Match match = Match.builder()
                .withDateTime(MATCH_DATE_TIME)
                .withTeam1(team1)
                .withTeam2(team2)
                .withNumber(MATCH_NUMBER)
                .withResult(result)
                .build();
        Optional<Match> savedMatch = manager.saveMatchObject(match);
        assertTrue(savedMatch.isPresent());
        assertEquals(1, manager.getMatchObjects().size());
        assertTrue(savedMatch.get().getId() > 0);

        Event event = Event.builder()
                .withMatch(match)
                .build();
        Optional<Event> savedEvent = manager.saveEventObject(event);
        assertTrue(savedEvent.isPresent());
        assertEquals(1, manager.getEventObjects().size());
        assertTrue(savedEvent.get().getId() > 0);
    }

    @Test
    @DisplayName("save NULL athlete object")
    @Transactional
    public void saveNULLAthleteObject() {
        Optional<Athlete> savedAthlete = manager.saveAthleteObject(null);
        assertFalse(savedAthlete.isPresent());
    }

    @Test
    @DisplayName("save NULL event object")
    @Transactional
    public void saveNULLEventObject() {
        Optional<Event> savedEvent = manager.saveEventObject(null);
        assertFalse(savedEvent.isPresent());
    }

    @Test
    @DisplayName("save NULL association object")
    @Transactional
    public void saveNULLAssociation() {
        Optional<Association> savedAssociation = manager.saveAssociationObject(null);
        assertFalse(savedAssociation.isPresent());
    }

    @Test
    @DisplayName("save NULL season object")
    @Transactional
    public void saveNULLSeasonObject() {
        Optional<Season> savedSeason = manager.saveSeasonObject(null);
        assertFalse(savedSeason.isPresent());
    }

    @Test
    @DisplayName("save NULL competition object")
    @Transactional
    public void saveNULLCompetitionObject() {
        Optional<Competition> savedCompetition = manager.saveCompetitionObject(null);
        assertFalse(savedCompetition.isPresent());
    }

    @Test
    @DisplayName("save NULL match object")
    @Transactional
    public void saveNULLMatchObject() {
        Optional<Match> savedMatch = manager.saveMatchObject(null);
        assertFalse(savedMatch.isPresent());
    }

    @Test
    @DisplayName("save NULL result object")
    @Transactional
    public void saveNULLResultObject() {
        Optional<Result> savedResult = manager.saveResultObject(null);
        assertFalse(savedResult.isPresent());
    }

    @Test
    @DisplayName("save NULL club object")
    @Transactional
    public void saveNULLClubObject() {
        Optional<Club> savedClub = manager.saveClubObject(null);
        assertFalse(savedClub.isPresent());
    }

    @Test
    @DisplayName("save NULL team object")
    @Transactional
    public void saveNULLTeamObject() {
        Optional<Team> savedTeam = manager.saveTeamObject(null);
        assertFalse(savedTeam.isPresent());
    }
}