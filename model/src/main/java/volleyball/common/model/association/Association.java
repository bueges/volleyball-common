package volleyball.common.model.association;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Association implements IAssociation {

    public static AssociationBuilder builder() {
        return new AssociationBuilder();
    }

    @NonNull
    @Getter
    private final String name;
}
