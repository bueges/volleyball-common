package volleyball.common.model.season;

import lombok.*;
import org.springframework.data.annotation.Id;
import volleyball.common.model.association.Association;
import volleyball.common.model.association.IAssociation;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Season implements ISeason {

    public static SeasonBuilder builder() {
        return new SeasonBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @Getter
    private final int periodStart;

    @Getter
    private final int periodEnd;

    @EqualsAndHashCode.Exclude
    private final Association association;

    public Optional<IAssociation> getAssociation() {
        return Optional.ofNullable(association);
    }
}
