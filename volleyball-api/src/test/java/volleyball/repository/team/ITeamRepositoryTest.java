package volleyball.repository.team;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.team.Team;
import volleyball.repository.club.IClubRepository;
import volleyball.repository.competition.ICompetitionRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.*;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class ITeamRepositoryTest {

    @Autowired
    ITeamRepository teamRepository;

    @Autowired
    ICompetitionRepository competitionRepository;

    @Autowired
    IClubRepository clubRepository;

    private Club club;
    private Competition competition;

    @BeforeEach
    public void init() {
        checkRepositorySize(teamRepository, 0);
        checkRepositorySize(competitionRepository, 0);
        checkRepositorySize(clubRepository, 0);

        competition = Competition.builder()
                .withName(COMPETITION_NAME)
                .build();
        log.info("build competition object : {}", competition);

        competition = competitionRepository.saveObject(competition);
        log.info("saved competition : {}", competition);
        checkRepositorySize(competitionRepository, 1);

        club = Club.builder()
                .withName(CLUB1_NAME)
                .build();
        log.info("build club object : {}", club);

        club = clubRepository.saveObject(club);
        log.info("saved club : {}", club);
        checkRepositorySize(clubRepository, 1);

        Team team = Team.builder()
                .withName(TEAM1_NAME)
                .withClub(club)
                .withCompetition(competition)
                .build();
        log.info("build team object : {}", team);

        team = teamRepository.saveObject(team);
        log.info("saved team : {}", team);
        checkRepositorySize(teamRepository, 1);
    }

    @Test
    @DisplayName("save same team object again")
    @Transactional
    public void saveSameTeamObjectAgain() {
        Team team2 = Team.builder()
                .withName(TEAM1_NAME)
                .withClub(club)
                .withCompetition(competition)
                .build();
        log.info("build team object : {}", team2);

        team2 = teamRepository.saveObject(team2);
        log.info("saved team : {}", team2);
        checkRepositorySize(teamRepository, 1);
    }

    @Test
    @DisplayName("save team object without competition")
    @Transactional
    public void saveTeamObjectWithoutCompetition() {
        Team team2 = Team.builder()
                .withName(TEAM1_NAME)
                .withClub(club)
                .build();
        log.info("build team object : {}", team2);

        team2 = teamRepository.saveObject(team2);
        log.info("saved team : {}", team2);
        checkRepositorySize(teamRepository, 2);
    }

    @Test
    @DisplayName("save team object without club")
    @Transactional
    public void saveTeamObjectWithoutClub() {
        Team team2 = Team.builder()
                .withName(TEAM1_NAME)
                .withCompetition(competition)
                .build();
        log.info("build team object : {}", team2);

        team2 = teamRepository.saveObject(team2);
        log.info("saved team : {}", team2);
        checkRepositorySize(teamRepository, 2);
    }

    @Test
    @DisplayName("save team object without competition and club")
    @Transactional
    public void saveTeamObjectWithoutCompetitionAndClub() {
        Team team2 = Team.builder()
                .withName(TEAM1_NAME)
                .build();
        log.info("build team object : {}", team2);

        team2 = teamRepository.saveObject(team2);
        log.info("saved team : {}", team2);
        checkRepositorySize(teamRepository, 2);
    }

    @Test
    @DisplayName("save NULL team object and check NPE")
    @Transactional
    public void saveNULLTeamObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> teamRepository.saveObject(null));
    }
}