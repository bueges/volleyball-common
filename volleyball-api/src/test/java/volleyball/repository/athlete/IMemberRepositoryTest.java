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
class IMemberRepositoryTest {

    @Autowired
    IAthleteRepository memberRepository;

    @BeforeEach
    public void init() {
        checkRepositorySize(memberRepository, 0);

        Athlete member = Athlete.builder()
                .withName(MEMBER_NAME)
                .withPreName(MEMBER_PRENAME)
                .withBirthday(MEMBER_BIRTHDAY)
                .withGender(MEMBER_GENDER)
                .build();
        log.info("build member object : {}", member);

        member = memberRepository.saveObject(member);
        log.info("saved member : {}", member);

        checkRepositorySize(memberRepository, 1);
    }

    @Test
    @DisplayName("save same member object again")
    @Transactional
    public void saveSameMemberObjectAgain() {
        Athlete member2 = Athlete.builder()
                .withName(MEMBER_NAME)
                .withPreName(MEMBER_PRENAME)
                .withBirthday(MEMBER_BIRTHDAY)
                .withGender(MEMBER_GENDER)
                .build();
        log.info("build member object : {}", member2);

        member2 = memberRepository.saveObject(member2);
        log.info("saved member : {}", member2);

        checkRepositorySize(memberRepository, 1);
    }

    @Test
    @DisplayName("save NULL member object and check NPE")
    @Transactional
    public void saveNULLMemberObjectAndCheckNPE() {
        assertThrows(NullPointerException.class, () -> memberRepository.saveObject(null));
    }
}