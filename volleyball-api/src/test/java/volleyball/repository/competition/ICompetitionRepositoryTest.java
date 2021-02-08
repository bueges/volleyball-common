package volleyball.repository.competition;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.competition.Competition;
import volleyball.model.season.Season;
import volleyball.repository.season.ISeasonRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.*;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class ICompetitionRepositoryTest {

    @Autowired
    ICompetitionRepository competitionRepository;

    @Autowired
    ISeasonRepository seasonRepository;

    private Season season;

    @BeforeEach
    public void init() {
        checkRepositorySize(competitionRepository, 0);
        checkRepositorySize(seasonRepository, 0);

        season = Season.builder()
                .withStartYear(SEASON_START_YEAR)
                .withEndYear(SEASON_END_YEAR)
                .build();
        log.info("build season object : {}", season);

        season = seasonRepository.saveObject(season);
        log.info("saved season : {}", season);
        checkRepositorySize(seasonRepository, 1);

        Competition competition = Competition.builder()
                .withName(COMPETITION_NAME)
                .withSeason(season)
                .build();
        log.info("build competition object : {}", competition);

        competition = competitionRepository.saveObject(competition);
        log.info("saved competition : {}", competition);
        checkRepositorySize(competitionRepository, 1);
    }

    @Test
    @DisplayName("save same competition object again")
    @Transactional
    public void saveSameCompetitionObjectAgain() {
        Competition competition2 = Competition.builder()
                .withName(COMPETITION_NAME)
                .withSeason(season)
                .build();
        log.info("build competition object : {}", competition2);

        competition2 = competitionRepository.saveObject(competition2);
        log.info("saved competition : {}", competition2);
        checkRepositorySize(competitionRepository, 1);
    }

    @Test
    @DisplayName("save competition object without season")
    @Transactional
    public void saveCompetitionWithoutSeason() {
        Competition competition2 = Competition.builder()
                .withName(COMPETITION_NAME)
                .build();
        log.info("build competition object : {}", competition2);

        competition2 = competitionRepository.saveObject(competition2);
        log.info("saved competition : {}", competition2);
        checkRepositorySize(competitionRepository, 2);
    }

    @Test
    @DisplayName("save NULL competition object and check NPE")
    @Transactional
    public void saveNULLCompetitionObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> competitionRepository.saveObject(null));
    }
}