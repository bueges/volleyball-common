package volleyball.common.model.season;

import lombok.*;
import volleyball.common.model.association.Association;
import volleyball.common.model.association.IAssociation;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Season implements ISeason {

    public static SeasonBuilder builder() {
        return new SeasonBuilder();
    }

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
