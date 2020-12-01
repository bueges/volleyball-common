package volleyball.common.model.club;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Club implements IClub {

    public static ClubBuilder builder() {
        return new ClubBuilder();
    }

    @NonNull
    @Getter
    private final String name;
}
