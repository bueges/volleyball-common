package volleyball.repository.event;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.event.Event;
import volleyball.model.match.Match;
import volleyball.model.team.Team;
import volleyball.repository.match.IMatchRepository;
import volleyball.repository.team.ITeamRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.*;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class IEventRepositoryTest {

    @Autowired
    IEventRepository eventRepository;

    @Autowired
    IMatchRepository matchRepository;

    @Autowired
    ITeamRepository teamRepository;

    private Team team1;
    private Team team2;
    private Match match;
    private Event event;

    @BeforeEach
    public void init() {
        checkRepositorySize(eventRepository, 0);
        checkRepositorySize(matchRepository, 0);
        checkRepositorySize(teamRepository, 0);

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

        match = Match.builder()
                .withDateTime(MATCH_DATE_TIME)
                .withTeam1(team1)
                .withTeam2(team2)
                .withNumber(MATCH_NUMBER)
                .build();
        log.info("build match object : {}", match);

        match = matchRepository.saveObject(match);
        log.info("saved match : {}", match);

        event = Event.builder()
                .withMatch(match)
                .build();
        log.info("build event object : {}", event);

        event = eventRepository.saveObject(event);
        log.info("saved event : {}", event);

        checkRepositorySize(eventRepository, 1);
    }

    @Test
    @DisplayName("save same event object again")
    @Transactional
    public void saveSameEventObjectAgain() {
        Event event2 = Event.builder()
                .withMatch(match)
                .build();
        log.info("build event object : {}", event);

        event2 = eventRepository.saveObject(event2);
        log.info("saved event : {}", event2);

        checkRepositorySize(eventRepository, 1);
    }

    @Test
    @DisplayName("save NULL event object and check NPE")
    @Transactional
    public void saveNULLEventObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> eventRepository.saveObject(null));
    }
}