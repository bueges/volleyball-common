package volleyball.repository.result;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.result.Result;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.RESULT_TEAM1_SETS;
import static volleyball.TestData.RESULT_TEAM2_SETS;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class IResultRepositoryTest {

    @Autowired
    IResultRepository resultRepository;

    @BeforeEach
    public void init() {
        Result result = Result.builder()
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .build();
        log.info("build result object : {}", result);

        result = resultRepository.saveObject(result);
        log.info("saved result : {}", result);

        checkRepositorySize(resultRepository, 1);
    }

    @Test
    @DisplayName("save same result object again")
    @Transactional
    public void saveSameResultObjectAgain() {
        Result result2 = Result.builder()
                .withSetsTeam1(RESULT_TEAM1_SETS)
                .withSetsTeam2(RESULT_TEAM2_SETS)
                .build();
        log.info("build result object : {}", result2);

        result2 = resultRepository.saveObject(result2);
        log.info("saved result : {}", result2);

        checkRepositorySize(resultRepository, 1);
    }

    @Test
    @DisplayName("save NULL result object and check NPE")
    @Transactional
    public void saveNULLResultObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> resultRepository.saveObject(null));
    }
}