package volleyball.repository.association;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestApplication;
import volleyball.model.association.Association;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static volleyball.TestData.ASSOCIATION_NAME;
import static volleyball.repository.RepositoryTestUtils.checkRepositorySize;

@SpringBootTest(classes = TestApplication.class)
@Slf4j
class IAssociationRepositoryTest {

    @Autowired
    IAssociationRepository associationRepository;

    @BeforeEach
    public void init() {
        checkRepositorySize(associationRepository, 0);

        Association association = Association.builder()
                .withName(ASSOCIATION_NAME)
                .build();
        log.info("build association object : {}", association);

        association = associationRepository.saveObject(association);
        log.info("saved association : {}", association);
        checkRepositorySize(associationRepository, 1);
    }

    @Test
    @DisplayName("save same association object again")
    @Transactional
    public void saveSameAssociationObjectAgain() {
        Association association2 = Association.builder()
                .withName(ASSOCIATION_NAME)
                .build();
        log.info("build association object : {}", association2);

        association2 = associationRepository.saveObject(association2);
        log.info("saved association : {}", association2);
        checkRepositorySize(associationRepository, 1);
    }

    @Test
    @DisplayName("save NULL association object and check NPE")
    @Transactional
    public void saveNULLAssociationObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> associationRepository.saveObject(null));
    }
}