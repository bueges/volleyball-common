package volleyball.common.model.member;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import volleyball.common.builder.BuilderException;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.*;

class MemberBuilderTest {

    private static final Logger logger = LogManager.getLogger(MemberBuilderTest.class);

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getMemberBuilderBirthday")
    @DisplayName("build member")
    public void buildMember(String birthday) throws BuilderException {
        Member member = Member.builder()
                .withName(MEMBER_NAME)
                .withPreName(MEMBER_PRENAME)
                .withBirthday(birthday)
                .withGender(MEMBER_GENDER).build();
        logger.info("build member : [{}]", member);

        assertNotNull(member);

        assertNotNull(member.getName());
        assertEquals(MEMBER_NAME, member.getName());

        assertNotNull(member.getPreName());
        assertEquals(MEMBER_PRENAME, member.getPreName());

        assertNotNull(member.getBirthday());
        assertEquals(MEMBER_BIRTHDAY, member.getBirthday());

        assertNotNull(member.getGender());
        assertEquals(MEMBER_GENDER, member.getGender());
    }

    @Test
    @DisplayName("build member with empty preName")
    public void buildMemberWithEmptyPreName() throws BuilderException {
        Member member = Member.builder()
                .withName(MEMBER_NAME)
                .withPreName("")
                .withBirthday(MEMBER_BIRTHDAY_TEXT)
                .withGender(MEMBER_GENDER).build();
        logger.info("build member : [{}]", member);

        assertNotNull(member);

        assertNotNull(member.getPreName());
        assertEquals("", member.getPreName());
    }

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getMemberBuilderData")
    @DisplayName("build member with invalid data and check BuilderException")
    public void buildMemberWithInvalidData(Pair<String, String> memberData) {
        assertThrows(BuilderException.class, () -> Member.builder()
                .withName(memberData.getLeft())
                .withPreName(memberData.getRight())
                .withBirthday(MEMBER_BIRTHDAY_TEXT)
                .withGender(MEMBER_GENDER).build());
    }

    @Test
    @DisplayName("build member without birthday and check BuilderException")
    public void buildMemberWithoutBirthday() {
        assertThrows(BuilderException.class, () -> Member.builder()
                .withName(MEMBER_NAME)
                .withPreName(MEMBER_PRENAME)
                .withGender(MEMBER_GENDER).build());
    }

    @Test
    @DisplayName("build member without gender and check BuilderException")
    public void buildMemberWithoutGender() {
        assertThrows(BuilderException.class, () -> Member.builder()
                .withName(MEMBER_NAME)
                .withPreName(MEMBER_PRENAME)
                .withBirthday(MEMBER_BIRTHDAY_TEXT)
                .build());
    }
}