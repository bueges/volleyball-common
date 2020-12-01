package volleyball.common.model.result;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Result implements IResult {

    public static ResultBuilder builder() {
        return new ResultBuilder();
    }

    @Getter
    private final int setsTeam1;

    @Getter
    private final int setsTeam2;
}
