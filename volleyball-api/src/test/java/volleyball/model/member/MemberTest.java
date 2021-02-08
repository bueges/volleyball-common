package volleyball.model.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.*;

@Slf4j
public class MemberTest {

    @Test
    @DisplayName("create member")
    public void createMember() {
        Member member = new Member(null, MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        log.info("create member : {}", member);

        assertNotNull(member);

        assertNotNull(member.getPreName());
        assertEquals(MEMBER_PRENAME, member.getPreName());

        assertNotNull(member.getBirthday());
        assertEquals(MEMBER_BIRTHDAY, member.getBirthday());
    }

    @Test
    @DisplayName("check NullPointerException when create member with null name")
    public void checkNullPointerExceptionWhenCreateMemberWithNullName() {
        assertThrows(NullPointerException.class, () -> new Member(null, null, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create member with null preName")
    public void throwsNullPointerExceptionWhenCreateMemberWithNullPreName() {
        assertThrows(NullPointerException.class, () -> new Member(null, MEMBER_NAME, null, MEMBER_BIRTHDAY, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create member with null birthday")
    public void checkNullPointerExceptionWhenCreateMemberWithNullBirthday() {
        assertThrows(NullPointerException.class, () -> new Member(null, MEMBER_NAME, MEMBER_PRENAME, null, Gender.MALE));
    }

    @Test
    @DisplayName("check NullPointerException when create member with null gender")
    public void checkNullPointerExceptionWhenCreateMemberWithNullGender() {
        assertThrows(NullPointerException.class, () -> new Member(null, MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, null));
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getMemberName")
    @DisplayName("compare members with same ID")
    public void compareMembersWithSameID() {
        Member member1 = new Member(1, MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member2 = new Member(1, MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member3 = new Member(1, "other-name", MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member4 = new Member(1, MEMBER_NAME, "other-prename", MEMBER_BIRTHDAY, Gender.MALE);
        Member member5 = new Member(1, MEMBER_NAME, MEMBER_PRENAME, LocalDate.now(), Gender.MALE);
        Member member6 = new Member(1, MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.FEMALE);

        log.info("compare members : ");
        log.info("member 1 : {}", member1);
        log.info("member 2 : {}", member2);
        log.info("member 3 : {}", member3);
        log.info("member 4 : {}", member4);
        log.info("member 5 : {}", member5);
        log.info("member 6 : {}", member6);

        assertEquals(member1, member2);
        assertEquals(member1, member3);
        assertEquals(member1, member4);
        assertEquals(member1, member5);
        assertEquals(member1, member6);
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getMemberName")
    @DisplayName("compare members with different ID")
    public void compareMembersWithDifferentID() {
        Member member1 = new Member(1, MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member2 = new Member(2, MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member3 = new Member(3, "other-name", MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.MALE);
        Member member4 = new Member(4, MEMBER_NAME, "other-prename", MEMBER_BIRTHDAY, Gender.MALE);
        Member member5 = new Member(5, MEMBER_NAME, MEMBER_PRENAME, LocalDate.now(), Gender.MALE);
        Member member6 = new Member(6, MEMBER_NAME, MEMBER_PRENAME, MEMBER_BIRTHDAY, Gender.FEMALE);

        log.info("compare members : ");
        log.info("member 1 : {}", member1);
        log.info("member 2 : {}", member2);
        log.info("member 3 : {}", member3);
        log.info("member 4 : {}", member4);
        log.info("member 5 : {}", member5);
        log.info("member 6 : {}", member6);

        assertNotEquals(member1, member2);
        assertNotEquals(member1, member3);
        assertNotEquals(member1, member4);
        assertNotEquals(member1, member5);
        assertNotEquals(member1, member6);
    }
}
