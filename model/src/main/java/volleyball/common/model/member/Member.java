package volleyball.common.model.member;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Member implements IMember {

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    @NonNull
    @Getter
    private final String name;

    @NonNull
    @Getter
    private final String preName;

    @NonNull
    @Getter
    private final LocalDate birthday;

    @NonNull
    @Getter
    private final Gender gender;
}
