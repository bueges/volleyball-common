package volleyball.common.model.member;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Member implements IMember {

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

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
