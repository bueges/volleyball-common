package volleyball.repository.season;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.association.Association;
import volleyball.model.season.Season;
import volleyball.repository.association.IAssociationRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.*;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class ISeasonRepositoryTest {

    @Autowired
    ISeasonRepository seasonRepository;

    @Autowired
    IAssociationRepository associationRepository;

    private Association association;

    @BeforeEach
    public void init() {
        checkRepositorySize(seasonRepository, 0);
        checkRepositorySize(associationRepository, 0);

        association = Association.builder()
                .withName(ASSOCIATION_NAME)
                .build();
        log.info("build association object : {}", association);

        association = associationRepository.saveObject(association);
        log.info("saved association : {}", association);
        checkRepositorySize(associationRepository, 1);

        Season season = Season.builder()
                .withStartYear(SEASON_START_YEAR)
                .withEndYear(SEASON_END_YEAR)
                .withAssociation(association)
                .build();
        log.info("build season object : {}", season);

        season = seasonRepository.saveObject(season);
        log.info("saved season : {}", season);
        checkRepositorySize(seasonRepository, 1);
    }

    @Test
    @DisplayName("save same season object again")
    @Transactional
    public void saveSameSeasonObjectAgain() {
        Season season2 = Season.builder()
                .withStartYear(SEASON_START_YEAR)
                .withEndYear(SEASON_END_YEAR)
                .withAssociation(association)
                .build();
        log.info("build season object : {}", season2);

        season2 = seasonRepository.saveObject(season2);
        log.info("saved season : {}", season2);

        checkRepositorySize(seasonRepository, 1);
    }

    @Test
    @DisplayName("save season object without association")
    @Transactional
    public void saveSeasonWithoutAssociation() {
        Season season2 = Season.builder()
                .withStartYear(SEASON_START_YEAR)
                .withEndYear(SEASON_END_YEAR)
                .build();
        log.info("build season object : {}", season2);

        season2 = seasonRepository.saveObject(season2);
        log.info("saved season : {}", season2);

        checkRepositorySize(seasonRepository, 2);
    }

    @Test
    @DisplayName("save NULL season object and check NPE")
    @Transactional
    public void saveNULLSeasonObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> seasonRepository.saveObject(null));
    }
}