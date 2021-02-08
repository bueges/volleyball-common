package volleyball.model.member;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class Member implements IMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    // required field
    @NonNull
    @Getter
    @EqualsAndHashCode.Exclude
    private String name;

    // required field
    @NonNull
    @Getter
    @EqualsAndHashCode.Exclude
    private String preName;

    // required field
    @NonNull
    @Getter
    @EqualsAndHashCode.Exclude
    private LocalDate birthday;

    // required field
    @NonNull
    @Getter
    @EqualsAndHashCode.Exclude
    private Gender gender;
}
