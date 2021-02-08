package volleyball.repository.match;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.match.Match;
import volleyball.model.result.Result;
import volleyball.model.team.Team;
import volleyball.repository.result.IResultRepository;
import volleyball.repository.team.ITeamRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.*;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class IMatchRepositoryTest {

    @Autowired
    IMatchRepository matchRepository;

    @Autowired
    ITeamRepository teamRepository;

    @Autowired
    IResultRepository resultRepository;

    private Team team1;
    private Team team2;
    private Result result;
    private Match match;

    @BeforeEach
    public void init() {
        checkRepositorySize(matchRepository, 0);
        checkRepositorySize(teamRepository, 0);
        checkRepositorySize(resultRepository, 0);

        team1 = Team.builder()
                .withName(TEAM1_NAME)
                .build();
        log.info("build team object : {}", team1);

        team1 = teamRepository.saveObject(team1);
        log.info("saved team : {}", team1);

        team2 = Team.builder()
                .withName(TEAM2_NAME)
                .build();
        log.info("build team object : {}", team2);

        team2 = teamRepository.saveObject(team2);
        log.info("saved team : {}", team2);

        result = Result.builder()
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .build();
        log.info("build result object : {}", result);

        result = resultRepository.saveObject(result);
        log.info("saved result : {}", result);

        match = Match.builder()
                .withDateTime(MATCH_DATE_TIME)
                .withTeam1(team1)
                .withTeam2(team2)
                .withNumber(MATCH_NUMBER)
                .withResult(result)
                .build();
        log.info("build match object : {}", match);

        match = matchRepository.saveObject(match);
        log.info("saved match : {}", match);

        checkRepositorySize(matchRepository, 1);
    }

    @Test
    @DisplayName("save same match object again")
    @Transactional
    public void saveSameMatchObjectAgain() {
        Match match2 = Match.builder()
                .withDateTime(MATCH_DATE_TIME)
                .withTeam1(team1)
                .withTeam2(team2)
                .withNumber(MATCH_NUMBER)
                .withResult(result)
                .build();
        log.info("build match object : {}", match);

        match2 = matchRepository.saveObject(match2);
        log.info("saved match : {}", match2);

        checkRepositorySize(matchRepository, 1);
    }

    @Test
    @DisplayName("save match objects without number")
    @Transactional
    public void saveMatchWithoutNumber() {
        Match match2 = Match.builder()
                .withDateTime(MATCH_DATE_TIME)
                .withTeam1(team1)
                .withTeam2(team2)
                .withResult(result)
                .build();
        log.info("build match object : {}", match);

        match2 = matchRepository.saveObject(match2);
        log.info("saved match : {}", match2);

        checkRepositorySize(matchRepository, 1);
    }

    @Test
    @DisplayName("save match objects without result")
    @Transactional
    public void saveMatchWithoutResult() {
        Match match2 = Match.builder()
                .withDateTime(MATCH_DATE_TIME)
                .withTeam1(team1)
                .withTeam2(team2)
                .withNumber(MATCH_NUMBER)
                .build();
        log.info("build match object : {}", match);

        match2 = matchRepository.saveObject(match2);
        log.info("saved match : {}", match2);

        checkRepositorySize(matchRepository, 1);
    }

    @Test
    @DisplayName("save NULL match object and check NPE")
    @Transactional
    public void saveNULLMatchObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> matchRepository.saveObject(null));
    }
}