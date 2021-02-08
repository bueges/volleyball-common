package volleyball.repository.club;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.club.Club;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.CLUB1_NAME;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class IClubRepositoryTest {

    @Autowired
    IClubRepository clubRepository;

    @BeforeEach
    public void init() {
        checkRepositorySize(clubRepository, 0);

        Club club = Club.builder()
                .withName(CLUB1_NAME)
                .build();
        log.info("build club object : {}", club);

        club = clubRepository.saveObject(club);
        log.info("saved club : {}", club);
        checkRepositorySize(clubRepository, 1);
    }

    @Test
    @DisplayName("save same club object again")
    @Transactional
    public void saveSameClubObjectAgain() {
        Club club2 = Club.builder()
                .withName(CLUB1_NAME)
                .build();
        log.info("build club object : {}", club2);

        club2 = clubRepository.saveObject(club2);
        log.info("saved club : {}", club2);
        checkRepositorySize(clubRepository, 1);
    }

    @Test
    @DisplayName("save NULL club object and check NPE")
    @Transactional
    public void saveNULLClubObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> clubRepository.saveObject(null));
    }
}