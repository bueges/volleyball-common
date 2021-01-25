package volleyball.model.builder.member;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestConstants.*;

class MemberTest {

    private static final Logger logger = LogManager.getLogger(MemberTest.class);

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getMemberPreName")
    @DisplayName("create member with valid pre name")
    public void createMemberWithValidPreName(String memberPreName) {
        Member member = new Member(MEMBER_NAME, memberPreName, MEMBER_BIRTHDAY, Gender.MALE);
        logger.info("create member : {}", member);

        assertNotNull(member);

        assertNotNull(member.getPreName());
        assertEquals(memberPreName, member.getPreName());

        assertNotNull(member.getBirthday());
        assertEquals(MEMBER_BIRTHDAY, member.getBirthday());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.builder.TestParameter#getMemberName")
    @DisplayName("create member with valid name")
    public void createMemberWithValidName(String memberName) {
        Member member = new Member(memberName, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        logger.info("create member : {}", member);

        assertNotNull(member);

        assertNotNull(member.getName());
        assertEquals(memberName, member.getName());
    }

    @Test
    @DisplayName("create member with valid gender")
    public void createMemberWithValidGender() {
        Member member = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        logger.info("create member : {}", member);

        assertNotNull(member);

        assertNotNull(member.getGender());
        assertEquals(Gender.MALE, member.getGender());
    }

    @Test
    @DisplayName("check NullPointerException when create member with null name")
    public void checkNullPointerExceptionWhenCreateMemberWithNullName() {
        assertThrows(NullPointerException.class, () -> new Member(null, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create member with null preName")
    public void throwsNullPointerExceptionWhenCreateMemberWithNullPreName() {
        assertThrows(NullPointerException.class, () -> new Member(MEMBER_NAME, null, MEMBER_BIRTHDAY, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create member with null birthday")
    public void checkNullPointerExceptionWhenCreateMemberWithNullBirthday() {
        assertThrows(NullPointerException.class, () -> new Member(MEMBER_NAME, MEMBER_PRENAME, null, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create member with null gender")
    public void checkNullPointerExceptionWhenCreateMemberWithNullGender() {
        assertThrows(NullPointerException.class, () -> new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, null));
    }

    @Test
    @DisplayName("compare two equal members")
    public void compareTwoEqualMembers() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member2 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);

        logger.info("compare members : ");
        logger.info("member 1 : {}", member1);
        logger.info("member 2 : {}", member2);

        assertEquals(member1, member2);
    }

    @Test
    @DisplayName("compare two members with different names")
    public void compareTwoMembersWithDifferentNames() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member2 = new Member("other-name", MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);

        logger.info("compare members : ");
        logger.info("member 1 : {}", member1);
        logger.info("member 2 : {}", member2);

        assertNotEquals(member1, member2);
    }

    @Test
    @DisplayName("compare two members with different preNames")
    public void compareTwoMembersWithDifferentPreNames() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member2 = new Member(MEMBER_NAME, "other-preName", MEMBER_BIRTHDAY, Gender.MALE);

        logger.info("compare members : ");
        logger.info("member 1 : {}", member1);
        logger.info("member 2 : {}", member2);

        assertNotEquals(member1, member2);
    }

    @Test
    @DisplayName("compare two members with different birthday")
    public void compareTwoMembersWithDifferentBirthdays() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member2 = new Member(MEMBER_NAME, MEMBER_PRENAME, LocalDate.of(2010, 1, 1), Gender.MALE);

        logger.info("compare members : ");
        logger.info("member 1 : {}", member1);
        logger.info("member 2 : {}", member2);

        assertNotEquals(member1, member2);
    }

    @Test
    @DisplayName("compare two members with different genders")
    public void compareTwoMembersWithDifferentGenders() {
        Member member1 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member2 = new Member(MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.FEMALE);

        logger.info("compare members : ");
        logger.info("member 1 : {}", member1);
        logger.info("member 2 : {}", member2);

        assertNotEquals(member1, member2);
    }
}