package volleyball.common.builder.member;


import volleyball.common.builder.BuilderException;
import volleyball.common.builder.IBuilder;
import volleyball.common.model.member.Gender;
import volleyball.common.model.member.IMember;

public interface IMemberBuilder extends IBuilder {

    IMemberBuilder withName(String name);

    IMemberBuilder withPreName(String preName);

    IMemberBuilder withBirthday(String birthday);

    IMemberBuilder withGender(Gender gender);

    @Override
    IMember build() throws BuilderException;
}
