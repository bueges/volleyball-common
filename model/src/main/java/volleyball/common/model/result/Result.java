package volleyball.common.model.result;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class Result implements IResult {

    public static ResultBuilder builder() {
        return new ResultBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @Getter
    private final int setsTeam1;

    @Getter
    private final int setsTeam2;
}
