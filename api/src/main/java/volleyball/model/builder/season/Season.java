package volleyball.model.builder.season;

import lombok.*;
import volleyball.model.builder.IModelObject;
import volleyball.model.builder.association.Association;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Entity
public class Season implements IModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @Getter
    private int startYear;

    @Getter
    private int endYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Association association;

    /**
     * constructor
     *
     * @param startYear   the season start year
     * @param endYear     the season end year
     * @param association the association reference
     */
    protected Season(int startYear, int endYear, Association association) {
        this.startYear = startYear;
        this.endYear = endYear;
        this.association = association;
    }

    public Optional<Association> getAssociation() {
        return Optional.ofNullable(association);
    }
}
