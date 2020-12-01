package volleyball.common.model.member;

import volleyball.common.builder.AbstractBuilder;
import volleyball.common.builder.BuilderException;
import volleyball.common.builder.member.IMemberBuilder;

import java.time.LocalDate;

public class MemberBuilder extends AbstractBuilder implements IMemberBuilder {

    private String name;
    private String preName;
    private String birthdayText;
    private Gender gender;

    @Override
    public MemberBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public MemberBuilder withPreName(String preName) {
        this.preName = preName;
        return this;
    }

    @Override
    public MemberBuilder withBirthday(String birthday) {
        this.birthdayText = birthday;
        return this;
    }

    @Override
    public MemberBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public Member build() throws BuilderException {
        isStringEmptyOrNull(name, "memberName");
        isStringEmptyOrNull(preName, "memberPreName", true);
        isObjectNull(gender, "memberGender");
        LocalDate birthday = convertStringToDate(birthdayText, "memberBirthday");
        isObjectNull(birthday, "birthday");

        return new Member(name, preName, birthday, gender);
    }
}
