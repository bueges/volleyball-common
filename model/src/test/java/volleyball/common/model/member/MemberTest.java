package volleyball.common.model.member;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.common.model.TestParameter.*;

class MemberTest {

    private static final Logger logger = LogManager.getLogger(MemberTest.class);

    @ParameterizedTest
    @MethodSource("volleyball.common.model.TestParameter#getMemberData")
    @DisplayName("create member")
    public void createMember(Pair<String, String> memberData) {
        Member member = new Member(memberData.getLeft(), memberData.getRight(), MEMBER_BIRTHDAY, MEMBER_GENDER);
        logger.info("create member : [{}]", member);

        assertNotNull(member);

        assertNotNull(member.getName());
        assertEquals(memberData.getLeft(), member.getName());

        assertNotNull(member.getPreName());
        assertEquals(memberData.getRight(), member.getPreName());

        assertNotNull(member.getBirthday());
        assertEquals(MEMBER_BIRTHDAY, member.getBirthday());

        assertNotNull(member.getGender());
        assertEquals(MEMBER_GENDER, member.getGender());
    }

    @Test
    @DisplayName("throws NullPointerException when create member with null name")
    public void throwsNullPointerExceptionWhenCreateMemberWithNullName() {
        assertThrows(NullPointerException.class, () -> new Member(null, MEMBER_PRENAME, MEMBER_BIRTHDAY, MEMBER_GENDER));
    }

    @Test
    @DisplayName("throws NullPointerException when create member with null preName")
    public void throwsNullPointerExceptionWhenCreateMemberWithNullPreName() {
        assertThrows(NullPointerException.class, () -> new Member(MEMBER_NAME, null, MEMBER_BIRTHDAY, MEMBER_GENDER));
    }

    @Test
    @DisplayName("throws NullPointerException when create member with null birthday")
    public void throwsNullPointerExceptionWhenCreateMemberWithNullBirthday() {
        assertThrows(NullPointerException.class, () -> new Member(MEMBER_NAME, MEMBER_PRENAME, null, MEMBER_GENDER));
    }

    @Test
    @DisplayName("throws NullPointerException when create member with null gender")
    public void throwsNullPointerExceptionWhenCreateMemberWithNullGender() {
        assertThrows(NullPointerException.class, () -> new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, null));
    }

    @Test
    @DisplayName("compare two equal members")
    public void compareTwoEqualMembers() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, MEMBER_GENDER);
        Member member2 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, MEMBER_GENDER);

        logger.info("compare members : ");
        logger.info("member 1 : [{}]", member1);
        logger.info("member 2 : [{}]", member2);

        assertEquals(member1, member2);
    }

    @Test
    @DisplayName("compare two members with different names")
    public void compareTwoMembersWithDifferentNames() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, MEMBER_GENDER);
        Member member2 = new Member("other-name", MEMBER_PRENAME, MEMBER_BIRTHDAY, MEMBER_GENDER);

        logger.info("compare members : ");
        logger.info("member 1 : [{}]", member1);
        logger.info("member 2 : [{}]", member2);

        assertNotEquals(member1, member2);
    }

    @Test
    @DisplayName("compare two members with different preNames")
    public void compareTwoMembersWithDifferentPreNames() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, MEMBER_GENDER);
        Member member2 = new Member(MEMBER_NAME, "other-preName", MEMBER_BIRTHDAY, MEMBER_GENDER);

        logger.info("compare members : ");
        logger.info("member 1 : [{}]", member1);
        logger.info("member 2 : [{}]", member2);

        assertNotEquals(member1, member2);
    }

    @Test
    @DisplayName("compare two members with different birthday")
    public void compareTwoMembersWithDifferentBirthdays() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, MEMBER_GENDER);
        Member member2 = new Member(MEMBER_NAME, MEMBER_PRENAME, LocalDate.of(2010, 1, 1), MEMBER_GENDER);

        logger.info("compare members : ");
        logger.info("member 1 : [{}]", member1);
        logger.info("member 2 : [{}]", member2);

        assertNotEquals(member1, member2);
    }

    @Test
    @DisplayName("compare two members with different genders")
    public void compareTwoMembersWithDifferentGenders() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, MEMBER_GENDER);
        Member member2 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.FEMALE);

        logger.info("compare members : ");
        logger.info("member 1 : [{}]", member1);
        logger.info("member 2 : [{}]", member2);

        assertNotEquals(member1, member2);
    }
}