package volleyball.model.builder.member;

import volleyball.model.builder.IModelObjectBuilder;

import java.time.LocalDate;
import java.util.Optional;

public abstract class MemberBuilder implements IModelObjectBuilder {

    private String name;
    private String preName;
    private LocalDate birthday;
    private Gender gender;

    /**
     * @param name the member name
     * @return the builder
     */
    public MemberBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @param preName the member pre name
     * @return the builder
     */
    public MemberBuilder withPreName(String preName) {
        this.preName = preName;
        return this;
    }

    /**
     * @param birthday the member birthday
     * @return the builder
     */
    public MemberBuilder withBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * @param gender the member gender
     * @return the builder
     */
    public MemberBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public Optional<Member> build() {
        return validateData() ? Optional.ofNullable(new Member(name, preName, birthday, gender)) : Optional.empty();
    }
}
