package volleyball.model.builder.result;

import lombok.*;
import volleyball.model.builder.IModelObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Entity
public class Result implements IModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @Getter
    private int setsTeam1;

    @Getter
    private int setsTeam2;

    /**
     * constructor
     *
     * @param setsTeam1 the result sets first team
     * @param setsTeam2 the result sets second team
     */
    protected Result(int setsTeam1, int setsTeam2) {
        this.setsTeam1 = setsTeam1;
        this.setsTeam2 = setsTeam2;
    }
}
