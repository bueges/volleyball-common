package volleyball.model.season;

import lombok.*;
import volleyball.model.association.Association;
import volleyball.model.association.IAssociation;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class Season implements ISeason {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    // required field
    @Getter
    @EqualsAndHashCode.Exclude
    private int startYear;

    // required field
    @Getter
    @EqualsAndHashCode.Exclude
    private int endYear;

    //optional field
    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Association association;

    public Optional<IAssociation> getAssociation() {
        return Optional.ofNullable(association);
    }
}
