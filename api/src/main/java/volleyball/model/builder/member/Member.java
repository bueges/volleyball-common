package volleyball.model.builder.member;

import lombok.*;
import volleyball.model.builder.IModelObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
@Entity
public class Member implements IModelObject {

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
