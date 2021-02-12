package volleyball.repository.athlete;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.athlete.Athlete;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.*;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class IAthleteRepositoryTest {

    @Autowired
    IAthleteRepository athleteRepository;

    @BeforeEach
    public void init() {
        checkRepositorySize(athleteRepository, 0);

        Athlete athlete = Athlete.builder()
                .withName(ATHLETE_NAME)
                .withPreName(ATHLETE_PRENAME)
                .withBirthday(ATHLETE_BIRTHDAY)
                .withGender(ATHLETE_GENDER)
                .build();
        log.info("build athlete object : {}", athlete);

        athlete = athleteRepository.saveObject(athlete);
        log.info("saved athlete : {}", athlete);

        checkRepositorySize(athleteRepository, 1);
    }

    @Test
    @DisplayName("save same athlete object again")
    @Transactional
    public void saveSameAthleteObjectAgain() {
        Athlete member2 = Athlete.builder()
                .withName(ATHLETE_NAME)
                .withPreName(ATHLETE_PRENAME)
                .withBirthday(ATHLETE_BIRTHDAY)
                .withGender(ATHLETE_GENDER)
                .build();
        log.info("build member object : {}", member2);

        member2 = athleteRepository.saveObject(member2);
        log.info("saved member : {}", member2);

        checkRepositorySize(athleteRepository, 1);
    }

    @Test
    @DisplayName("save NULL athlete object and check NPE")
    @Transactional
    public void saveNULLAthleteObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> athleteRepository.saveObject(null));
    }
}